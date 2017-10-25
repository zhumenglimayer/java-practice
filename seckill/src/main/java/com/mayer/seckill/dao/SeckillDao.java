package com.mayer.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mayer.seckill.entity.Seckill;

public interface SeckillDao {
//	减库存
	int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime")Date killTime);
//	查询商品
	Seckill queryById(long seckillId);
//	根据偏移量查询商品列表
	List<Seckill> queryAll(@Param("offset")int offset,@Param("limit")int limit);
}
