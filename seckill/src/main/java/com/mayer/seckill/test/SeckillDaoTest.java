package com.mayer.seckill.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mayer.seckill.dao.SeckillDao;
import com.mayer.seckill.entity.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class SeckillDaoTest {
	
	@Autowired
	private SeckillDao seckillDao;

	
	@Test
	public void testReduceNumber() throws Exception{
		
	}
	
	@Test
	public void testQueryById() throws Exception{
		System.out.println(seckillDao);
//		long id = 1000;
//		Seckill seckill = seckillDao.queryById(id);
//		System.out.println(seckill.getName());
//		System.out.println(seckill);
	}
	
	@Test
	public void testQueryAll() throws Exception{
		
	}
}
