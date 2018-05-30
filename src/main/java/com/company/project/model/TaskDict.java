package com.company.project.model;

import java.util.Date;

public class TaskDict {
   private String code;
   private int isDeleted;
   private String createTime;
   private Date cTime;
   
   private String typeName;
   private String description;
   private String updateTime;
   private Date uTime;
   
   private int id;
   private int type;
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public int getIsDeleted() {
	return isDeleted;
}
public void setIsDeleted(int isDeleted) {
	this.isDeleted = isDeleted;
}
public String getCreateTime() {
	return createTime;
}
public void setCreateTime(String createTime) {
	this.createTime = createTime;
}
public Date getcTime() {
	return cTime;
}
public void setcTime(Date cTime) {
	this.cTime = cTime;
}
public String getTypeName() {
	return typeName;
}
public void setTypeName(String typeName) {
	this.typeName = typeName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getUpdateTime() {
	return updateTime;
}
public void setUpdateTime(String updateTime) {
	this.updateTime = updateTime;
}
public Date getuTime() {
	return uTime;
}
public void setuTime(Date uTime) {
	this.uTime = uTime;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
@Override
public String toString() {
	return "TaskDict [code=" + code + ", isDeleted=" + isDeleted + ", createTime=" + createTime + ", cTime=" + cTime
			+ ", typeName=" + typeName + ", description=" + description + ", updateTime=" + updateTime + ", uTime="
			+ uTime + ", id=" + id + ", type=" + type + "]";
}
   
   
}
