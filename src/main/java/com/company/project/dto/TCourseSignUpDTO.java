package com.company.project.dto;

import java.util.Date;

/**
 * 课程预约 列表封装实体类
 * @author tanfan
 *
 */
public class TCourseSignUpDTO {
   private int id;//课程预约id
   private int cid;//课程id
   private String img;//
   private String name;//课程名称
   private Date stime;//课程开始时间
   private Integer chour;//总课时
   private Integer acount;
   private Integer count;
   private String tname;
   private Integer rstatus;// 是否预订餐饮 1 是 2否
   private Integer astatus;// 是否预订住宿 1 是 2否
   private Date cratetime;// 预订时间 即下单时间
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getStime() {
	return stime;
}
public void setStime(Date stime) {
	this.stime = stime;
}
public Integer getChour() {
	return chour;
}
public void setChour(Integer chour) {
	this.chour = chour;
}
public Integer getAcount() {
	return acount;
}
public void setAcount(Integer acount) {
	this.acount = acount;
}
public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public Integer getRstatus() {
	return rstatus;
}
public void setRstatus(Integer rstatus) {
	this.rstatus = rstatus;
}
public Integer getAstatus() {
	return astatus;
}
public void setAstatus(Integer astatus) {
	this.astatus = astatus;
}
public Date getCratetime() {
	return cratetime;
}
public void setCratetime(Date cratetime) {
	this.cratetime = cratetime;
}
   
   
}
