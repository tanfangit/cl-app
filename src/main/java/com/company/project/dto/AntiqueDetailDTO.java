package com.company.project.dto;

import java.util.Date;

/**
 * 用于定时任务同步文玩数据 实体类
 * @author tanfan
 *
 */
public class AntiqueDetailDTO {
	 //文玩id
     private int id;
     // 文玩编号
     private String goodsNum; 
     //文玩名称
     private String goodsName;
     //文玩类别old_id
     private int category;
     //文玩类别new_id
     private int typeid;
     //来源old_id
     private int source;
     //来源new_id
     private int sid;
     //年代old_id
     private int years;
     //年代new_id
     private int yid;
     
     //展览位置 old_id
     private int exhibitionAddress;
     //展览位置 new_id
     private int aid;
     
     //材质
     private String material;
     //物品尺寸
     private String sizeDesc;
     //重量
     private String weight;
     //物品简介
     private String goodsSynopsis;
     //列表页图片 多个以,拼接
     private String listPageImgStr;
     //文玩新增时间
     private String createTime;
     //文玩最新修改时间
     private String modifyTime;
     private Date cdate;
     private Date mdate;
     //逻辑删除标志 0 正常 1删除
     private int isdel;
     //状态对应字典表
     private int status;
     
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public int getYid() {
		return yid;
	}
	public void setYid(int yid) {
		this.yid = yid;
	}
	 
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getSizeDesc() {
		return sizeDesc;
	}
	public void setSizeDesc(String sizeDesc) {
		this.sizeDesc = sizeDesc;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getGoodsSynopsis() {
		return goodsSynopsis;
	}
	public void setGoodsSynopsis(String goodsSynopsis) {
		this.goodsSynopsis = goodsSynopsis;
	}
	
	
	public String getListPageImgStr() {
		return listPageImgStr;
	}
	public void setListPageImgStr(String listPageImgStr) {
		this.listPageImgStr = listPageImgStr;
	}
	public int getExhibitionAddress() {
		return exhibitionAddress;
	}
	public void setExhibitionAddress(int exhibitionAddress) {
		this.exhibitionAddress = exhibitionAddress;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	public int getIsdel() {
		return isdel;
	}
	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}
     
}
