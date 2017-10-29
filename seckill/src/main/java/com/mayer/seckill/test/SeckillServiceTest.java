package com.mayer.seckill.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mayer.seckill.dao.SeckillDao;
import com.mayer.seckill.dto.Exposer;
import com.mayer.seckill.dto.SeckillExcution;
import com.mayer.seckill.entity.Seckill;
import com.mayer.seckill.exception.RepeatKillException;
import com.mayer.seckill.exception.SeckillCloseException;
import com.mayer.seckill.service.SeckillService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:spring-service.xml"})
public class SeckillServiceTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;

	
	@Test
	public void testGetSeckillList() throws Exception{
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list={}", list);
	}
	
	@Test
	public void testGetById() throws Exception{
		long id = 1;
		Seckill seckill = seckillService.getById(id);
		logger.info("seckill={}", seckill);
	}
	
	@Test
	public void testExportSeckillUrl() throws Exception{
		long seckillId = 2;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if(exposer.isExpo()){
			logger.info("Exposer={}", exposer);
			long userPhone = 14798765432L;
			String md5 = exposer.getMd5();
			try {
				SeckillExcution seckillExcution = seckillService.executeSeckill(seckillId, userPhone, md5);
				logger.info("result={}", seckillExcution);
			} catch (RepeatKillException e) {
				logger.error(e.getMessage());
			} catch (SeckillCloseException e) {
				logger.error(e.getMessage());
			}
		}else{
			logger.warn("exposer={}",exposer);
		}
		
	}
	
	
}
