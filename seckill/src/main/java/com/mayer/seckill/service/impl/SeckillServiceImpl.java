package com.mayer.seckill.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.mayer.seckill.dao.SeckillDao;
import com.mayer.seckill.dao.SuccessKilledDao;
import com.mayer.seckill.dao.cache.RedisDao;
import com.mayer.seckill.dto.Exposer;
import com.mayer.seckill.dto.SeckillExcution;
import com.mayer.seckill.entity.Seckill;
import com.mayer.seckill.entity.Successkilled;
import com.mayer.seckill.enums.SeckillStateEnum;
import com.mayer.seckill.exception.RepeatKillException;
import com.mayer.seckill.exception.SeckillCloseException;
import com.mayer.seckill.exception.SeckillException;
import com.mayer.seckill.service.SeckillService;

@Service
public class SeckillServiceImpl implements SeckillService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillDao seckillDao;
	
	@Autowired
	private RedisDao redisDao;
	
	@Autowired
	private SuccessKilledDao successKilledDao;
	// 作为md5的盐值，混淆md5
	private final String salt = "35ghasdjgfdsadsadyu2$^(*%dasda#";

	@Override
	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0, 5);
	}

	@Override
	public Seckill getById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}

	@Override
	public Exposer exportSeckillUrl(long seckillId) {
//		缓存优化
		Seckill seckill = redisDao.getSeckill(seckillId);
		if(seckill==null){
			seckill = seckillDao.queryById(seckillId);
			if (seckill == null) {
				return new Exposer(false, seckillId);
			}else{
				redisDao.putSeckill(seckill);
			}
		}
		
		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		Date nowTime = new Date();
		if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
			return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
		}
		String md5 = getMD5(seckillId);
		return new Exposer(true, md5, seckillId);
	}

	private String getMD5(long seckillId) {
		String base = seckillId + "/" + salt;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}

	@Override
	@Transactional
	public SeckillExcution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {
		// TODO Auto-generated method stub
		if (md5 == null || !md5.equals(getMD5(seckillId))) {
			throw new SeckillException("seckill data rewrite");
		}
		Date nowTime = new Date();
		try {
			int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
			if (updateCount <= 0) {
				throw new SeckillCloseException("seckilled is closed");
			} else {
				int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
				if (insertCount <= 0) {
					throw new RepeatKillException("seckill repeated");
				} else {
					Successkilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
					return new SeckillExcution(seckillId, SeckillStateEnum.SUCCESS, successKilled);
				}
			}
		} catch (SeckillCloseException e1) {
			// TODO: handle exception
			throw e1;
		} catch (RepeatKillException e2) {
			// TODO: handle exception
			throw e2;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SeckillException("seckill inner error :" + e.getMessage());
		}

	}

}
