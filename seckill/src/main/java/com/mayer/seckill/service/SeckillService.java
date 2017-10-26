package com.mayer.seckill.service;

import java.util.List;

import com.mayer.seckill.dto.Exposer;
import com.mayer.seckill.dto.SeckillExcution;
import com.mayer.seckill.entity.Seckill;
import com.mayer.seckill.exception.RepeatKillException;
import com.mayer.seckill.exception.SeckillCloseException;
import com.mayer.seckill.exception.SeckillException;

public interface SeckillService {
	
//	查询所有秒杀商品
	List<Seckill> getSeckillList();
//	查询单个秒杀商品
	Seckill getById(long seckillId);
//	秒杀开启时输出秒杀接口地址，否则输出系统时间和秒杀时间
	Exposer exportSeckillUrl(long seckillId);
//	执行秒杀
	SeckillExcution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException,RepeatKillException,SeckillCloseException;
}
