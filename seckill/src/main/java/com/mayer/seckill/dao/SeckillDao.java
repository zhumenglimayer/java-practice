package com.mayer.seckill.dao;

import java.util.Date;
import java.util.List;

import com.mayer.seckill.entity.Seckill;

public interface SeckillDao {
//	减库存
	int reduceNumber(long seckillId,Date killTime);
//	查询商品
	Seckill queryById(long seckillId);
//	根据偏移量查询商品列表
	List<Seckill> queryAll(int offset,int limit);
}
