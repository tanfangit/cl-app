package com.company.project.model;

import java.util.Date;

public class CourseReservationDelete {
   private int id;
   private int cId;
   private int mId;
   private int day;
   private Date crateTime;
   private Date deleteTime;
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
public int getDay() {
	return day;
}
public void setDay(int day) {
	this.day = day;
}
public Date getCrateTime() {
	return crateTime;
}
public void setCrateTime(Date crateTime) {
	this.crateTime = crateTime;
}
public Date getDeleteTime() {
	return deleteTime;
}
public void setDeleteTime(Date deleteTime) {
	this.deleteTime = deleteTime;
}

   
   
}
