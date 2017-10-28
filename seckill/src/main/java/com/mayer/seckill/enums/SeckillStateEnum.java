package com.mayer.seckill.enums;

public enum SeckillStateEnum {
	private int state;
	private String stateInfo;
	
	

	SeckillStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	public static SeckillStateEnum stateOf(int index){
		for (SeckillStateEnum state : values()) {
			
		}
	}
}
