package com.mayer.seckill.dto;

//暴露秒杀地址DTO
public class Exposer {
	private boolean expo;
	private String md5;
	private long seckillId;
	private long now;
	private long start;
	private long end;
	public Exposer(boolean expo, String md5, long seckillId) {
		super();
		this.expo = expo;
		this.md5 = md5;
		this.seckillId = seckillId;
	}
	public Exposer(boolean expo, long now, long start, long end) {
		super();
		this.expo = expo;
		this.now = now;
		this.start = start;
		this.end = end;
	}
	public Exposer(boolean expo, long seckillId) {
		super();
		this.expo = expo;
		this.seckillId = seckillId;
	}
	public Exposer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isExpo() {
		return expo;
	}
	public void setExpo(boolean expo) {
		this.expo = expo;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	public long getNow() {
		return now;
	}
	public void setNow(long now) {
		this.now = now;
	}
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public long getEnd() {
		return end;
	}
	public void setEnd(long end) {
		this.end = end;
	}
	
}
