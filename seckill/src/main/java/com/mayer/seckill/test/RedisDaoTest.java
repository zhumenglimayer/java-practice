package com.mayer.seckill.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mayer.seckill.dao.SeckillDao;
import com.mayer.seckill.dao.cache.RedisDao;
import com.mayer.seckill.entity.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class RedisDaoTest {
	
	private long id = 1;
	
	@Autowired
	private RedisDao redisDao;
	
	@Autowired
	private SeckillDao seckillDao;
	
	@Test
	public void testSeckill() throws Exception{
		Seckill seckill = redisDao.getSeckill(id);
		if(seckill==null){
			seckill = seckillDao.queryById(id);
			if(seckill!=null){
				String result = redisDao.putSeckill(seckill);
				System.out.println(result);
				seckill = redisDao.getSeckill(id);
				System.out.println(seckill);
			}
		}
	}
}
