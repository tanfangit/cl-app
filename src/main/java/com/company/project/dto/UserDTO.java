package com.company.project.dto;

import java.util.Date;

import com.company.project.model.TMember;

/**
 * 微信用户
 * @author tanfan
 *
 */
public class UserDTO {
	private int id;
    private String openid;
    private String nickname;
    private String sex;
    private String province;
    private String city;
    private String country;
    private String headimgurl;
    private String privilege;
    private String unionid;
    private String  regstatus;// 0 否  1 已注册  
    private TMember tMember; // 会员 用于微信用户自动登录
    private Date  cratetime;
    
	 
	public TMember gettMember() {
		return tMember;
	}
	public void settMember(TMember tMember) {
		this.tMember = tMember;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCratetime() {
		return cratetime;
	}
	public void setCratetime(Date cratetime) {
		this.cratetime = cratetime;
	}
	public String getRegstatus() {
		return regstatus;
	}
	public void setRegstatus(String regstatus) {
		this.regstatus = regstatus;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	@Override
	public String toString() {
		return "UserDTO [openid=" + openid + ", nickname=" + nickname
				+ ", sex=" + sex + ", province=" + province + ", city=" + city
				+ ", country=" + country + ", headimgurl=" + headimgurl
				+ ", privilege=" + privilege + ", unionid=" + unionid + "]";
	}
    
}
