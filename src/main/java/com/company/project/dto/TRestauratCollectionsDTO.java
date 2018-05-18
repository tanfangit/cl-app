package com.company.project.dto;

import java.util.Date;

import com.company.project.model.TRestaurantDetail;

public class TRestauratCollectionsDTO extends TRestaurantDetail{
	private Date cTime ;//收藏时间
	private int cid;// 收藏id
	private int status;// 状态  1 已结束 2 未开始 3 进行中
	public Date getcTime() {
		return cTime;
	}
	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
