package com.mayer.seckill.entity;

import java.util.Date;

public class Successkilled extends SuccesskilledKey {
    private Byte state;

    private Date createTime;

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
}