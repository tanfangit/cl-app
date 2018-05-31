package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_otherreservations")
public class TOtherreservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 会员id
     */
    @Column(name = "mId")
    private Integer mid;
    
    /**
     * 课程预约id
     */
    @Column(name = "cId")
    private Integer cid;

    /**
     * 1 大象国际文玩 2莫干山文玩 3 大象国际加莫干山
     */
    private Integer atype;

    /**
     * 体验类项目id 多个以,拼接
     */
    private String eids;

    /**
     * 餐饮类型id 多个以,拼接
     */
    private String rtypeids;
    /**
     * 用餐总人数
     */
    private String rnum;
    /**
     * 你的姓名
     */
    private String unames;

    /**
     * 你的手机
     */
    private String uphone;

    /**
     * 1男 2女
     */
    private Integer usex;

    /**
     * 健康状况
     */
    private String health;

    /**
     * 备注说明
     */
    private String explains;

    /**
     * 实际预约时间多个以，拼接
     */
    private String dates;

    /**
     * 预约开始时间
     */
    private Date sdate;

    /**
     * 预约结束时间
     */
    private Date edate;

    /**
     * 总共预约多少天
     */
    private Integer days;

    /**
     * 状态 0 未确认 1已确认
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "crate_time")
    private Date crateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取会员id
     *
     * @return mId - 会员id
     */
    public Integer getMid() {
        return mid;
    }

    /**
     * 设置会员id
     *
     * @param mid 会员id
     */
    public void setMid(Integer mid) {
        this.mid = mid;
    }

    /**
     * 获取1 大象国际文玩 2莫干山文玩 3 大象国际加莫干山
     *
     * @return atype - 1 大象国际文玩 2莫干山文玩 3 大象国际加莫干山
     */
    public Integer getAtype() {
        return atype;
    }

    /**
     * 设置1 大象国际文玩 2莫干山文玩 3 大象国际加莫干山
     *
     * @param atype 1 大象国际文玩 2莫干山文玩 3 大象国际加莫干山
     */
    public void setAtype(Integer atype) {
        this.atype = atype;
    }

    /**
     * 获取体验类项目id 多个以,拼接
     *
     * @return eids - 体验类项目id 多个以,拼接
     */
    public String getEids() {
        return eids;
    }

    /**
     * 设置体验类项目id 多个以,拼接
     *
     * @param eids 体验类项目id 多个以,拼接
     */
    public void setEids(String eids) {
        this.eids = eids;
    }

    /**
     * 获取餐饮类型id 多个以,拼接
     *
     * @return rtypeids - 餐饮类型id 多个以,拼接
     */
    public String getRtypeids() {
        return rtypeids;
    }

    /**
     * 设置餐饮类型id 多个以,拼接
     *
     * @param rtypeids 餐饮类型id 多个以,拼接
     */
    public void setRtypeids(String rtypeids) {
        this.rtypeids = rtypeids;
    }

    public String getRnum() {
		return rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
	}

	/**
     * 获取你的姓名
     *
     * @return uname - 你的姓名
     */
    public String getUnames() {
        return unames;
    }

    /**
     * 设置你的姓名
     *
     * @param uname 你的姓名
     */
    public void setUnames(String uname) {
        this.unames = uname;
    }

    /**
     * 获取你的手机
     *
     * @return uphone - 你的手机
     */
    public String getUphone() {
        return uphone;
    }

    /**
     * 设置你的手机
     *
     * @param uphone 你的手机
     */
    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    /**
     * 获取1男 2女
     *
     * @return usex - 1男 2女
     */
    public Integer getUsex() {
        return usex;
    }

    /**
     * 设置1男 2女
     *
     * @param usex 1男 2女
     */
    public void setUsex(Integer usex) {
        this.usex = usex;
    }

    /**
     * 获取健康状况
     *
     * @return health - 健康状况
     */
    public String getHealth() {
        return health;
    }

    /**
     * 设置健康状况
     *
     * @param health 健康状况
     */
    public void setHealth(String health) {
        this.health = health;
    }

    /**
     * 获取备注说明
     *
     * @return explains - 备注说明
     */
    public String getExplains() {
        return explains;
    }

    /**
     * 设置备注说明
     *
     * @param explains 备注说明
     */
    public void setExplains(String explains) {
        this.explains = explains;
    }

    /**
     * 获取实际预约时间多个以，拼接
     *
     * @return dates - 实际预约时间多个以，拼接
     */
    public String getDates() {
        return dates;
    }

    /**
     * 设置实际预约时间多个以，拼接
     *
     * @param dates 实际预约时间多个以，拼接
     */
    public void setDates(String dates) {
        this.dates = dates;
    }

    /**
     * 获取预约开始时间
     *
     * @return sdate - 预约开始时间
     */
    public Date getSdate() {
        return sdate;
    }

    /**
     * 设置预约开始时间
     *
     * @param sdate 预约开始时间
     */
    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    /**
     * 获取预约结束时间
     *
     * @return edate - 预约结束时间
     */
    public Date getEdate() {
        return edate;
    }

    /**
     * 设置预约结束时间
     *
     * @param edate 预约结束时间
     */
    public void setEdate(Date edate) {
        this.edate = edate;
    }

    /**
     * 获取总共预约多少天
     *
     * @return days - 总共预约多少天
     */
    public Integer getDays() {
        return days;
    }

    /**
     * 设置总共预约多少天
     *
     * @param days 总共预约多少天
     */
    public void setDays(Integer days) {
        this.days = days;
    }

    /**
     * 获取状态 0 未确认 1已确认
     *
     * @return status - 状态 0 未确认 1已确认
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0 未确认 1已确认
     *
     * @param status 状态 0 未确认 1已确认
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return crate_time - 创建时间
     */
    public Date getCrateTime() {
        return crateTime;
    }

    /**
     * 设置创建时间
     *
     * @param crateTime 创建时间
     */
    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
    
}