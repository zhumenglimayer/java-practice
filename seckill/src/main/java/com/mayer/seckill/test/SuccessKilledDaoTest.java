package com.mayer.seckill.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mayer.seckill.dao.SuccessKilledDao;
import com.mayer.seckill.entity.Successkilled;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class SuccessKilledDaoTest {
	
	@Resource
	private SuccessKilledDao successKilledDao;

	@Test
	public void testInsertSuccessKilled() throws Exception{
		long id = 2L;
		long phone = 13123456789L;
		int insertCount = successKilledDao.insertSuccessKilled(id, phone);
		System.out.println("insertCount=" + insertCount);
	}
	
	@Test
	public void testQueryByIdWithSeckill() throws Exception{
		long id = 2L;
		long phone = 13123456789L;
		Successkilled successkilled = successKilledDao.queryByIdWithSeckill(id, phone);
		System.out.println(successkilled);
		System.out.println(successkilled.getSeckill());
		
	}

}
