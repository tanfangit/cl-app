package com.company.project.model;

import java.util.Date;

public class CourseReservation {
    private int id;
    private int cId;
    private int mId;
    private Date crateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public Date getCrateTime() {
		return crateTime;
	}
	public void setCrateTime(Date crateTime) {
		this.crateTime = crateTime;
	}
	 
    
}
