package com.mayer.seckill.entity;

import java.util.Date;

public class Successkilled extends SuccesskilledKey {
    private Byte state;

    private Date createTime;
    
    private Seckill seckill;
    
    

    public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "Successkilled ["+super.toString()+",state=" + state + ", createTime=" + createTime + ", seckill=" + seckill + "]";
	}
    
    

	
    
    
}