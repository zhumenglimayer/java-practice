package com.mayer.seckill.dao;

import com.mayer.seckill.entity.Successkilled;

public interface SuccessKilledDao {
//	插入购买明细
	int insertSuccessKilled(long seckillId,long userPhone);
//	
	Successkilled queryByIdWithSeckill(long seckillId);
}
