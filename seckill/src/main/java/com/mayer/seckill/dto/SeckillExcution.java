package com.mayer.seckill.dto;

import com.mayer.seckill.entity.Successkilled;
import com.mayer.seckill.enums.SeckillStateEnum;

//封装执行后结果
public class SeckillExcution {
	private long seckillId;
	
//	秒杀执行结果状态
	private int state;
//	状态表示
	private String stateInfo;
	
	private Successkilled successkilled;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public Successkilled getSuccesskilled() {
		return successkilled;
	}

	public void setSuccesskilled(Successkilled successkilled) {
		this.successkilled = successkilled;
	}

	public SeckillExcution(long seckillId, SeckillStateEnum stateEnum, Successkilled successkilled) {
		super();
		this.seckillId = seckillId;
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.successkilled = successkilled;
	}

	public SeckillExcution(long seckillId, SeckillStateEnum stateEnum) {
		super();
		this.seckillId = seckillId;
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	public SeckillExcution() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
