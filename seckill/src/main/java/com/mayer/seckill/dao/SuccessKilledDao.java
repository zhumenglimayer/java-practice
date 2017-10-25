package com.mayer.seckill.dao;

import org.apache.ibatis.annotations.Param;

import com.mayer.seckill.entity.Successkilled;

public interface SuccessKilledDao {
//	插入购买明细
	int insertSuccessKilled(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
//	
	Successkilled queryByIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
}
