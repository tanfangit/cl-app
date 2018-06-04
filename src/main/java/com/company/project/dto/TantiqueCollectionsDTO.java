package com.company.project.dto;

import java.util.Date;

import com.company.project.model.TAntiqueDetail;

public class TantiqueCollectionsDTO extends TAntiqueDetail{
	private Date cTime ;//收藏时间
	private int cid;// 收藏id
	private int status;// 状态  1 已结束 2 未开始 3 进行中
	/**
     * 来源名称
     */
    private String sourcename;
    /**
     * 类别名称
     */
    private String typename;
    private String yearname;
    
    
	public String getYearname() {
		return yearname;
	}
	public void setYearname(String yearname) {
		this.yearname = yearname;
	}
	public String getSourcename() {
		return sourcename;
	}
	public void setSourcename(String sourcename) {
		this.sourcename = sourcename;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
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
