package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_member")
public class TMember {
    /**
     * 会员ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 会员名称
     */
    @Column(name = "memberName")
    private String membername;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 会员号
     */
    @Column(name = "memberNumber")
    private String membernumber;

    /**
     * 状态 0正常 1注销
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "crate_time")
    private Date crateTime;

    /**
     * 会员开通时间
     */
    @Column(name = "open_time")
    private Date openTime;

    /**
     * 推荐人姓名
     */
    @Column(name = "refereeName")
    private String refereename;

    /**
     * 推荐人手机
     */
    @Column(name = "refereePhone")
    private String refereephone;

    /**
     * 会员级别
     */
    private Integer level;

    /**
     * 是否临时会员 0 是 1否
     */
    @Column(name = "isTemp")
    private Integer istemp;

    /**
     * 开通类型 1申请开通 2人工开通
     */
    @Column(name = "openType")
    private Integer opentype;

    /**
     * 剩余金额
     */
    @Column(name = "surplusAmount")
    private BigDecimal surplusamount;

    /**
     * 会员有效期截止时间
     */
    @Column(name = "validity_time")
    private Date validityTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 微信号
     */
    @Column(name = "wxAccount")
    private String wxaccount;

    /**
     * 微信头像
     */
    private String acatar;

    /**
     * 验证码
     */
    private String captcha;

    /**
     * 唯一标识码
     */
    @Column(name = "idCode")
    private String idcode;

    /**
     * 开通人用户id
     */
    @Column(name = "openUserId")
    private Integer openuserid;

    /**
     * 开通人用户账号名称
     */
    @Column(name = "openUserName")
    private String openusername;
    
    private Date captchaTime;
    
    

    public Date getCaptchaTime() {
		return captchaTime;
	}

	public void setCaptchaTime(Date captchaTime) {
		this.captchaTime = captchaTime;
	}

	/**
     * 获取会员ID
     *
     * @return id - 会员ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置会员ID
     *
     * @param id 会员ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取会员名称
     *
     * @return memberName - 会员名称
     */
    public String getMembername() {
        return membername;
    }

    /**
     * 设置会员名称
     *
     * @param membername 会员名称
     */
    public void setMembername(String membername) {
        this.membername = membername;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取会员号
     *
     * @return memberNumber - 会员号
     */
    public String getMembernumber() {
        return membernumber;
    }

    /**
     * 设置会员号
     *
     * @param membernumber 会员号
     */
    public void setMembernumber(String membernumber) {
        this.membernumber = membernumber;
    }

    /**
     * 获取状态 0正常 1注销
     *
     * @return status - 状态 0正常 1注销
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0正常 1注销
     *
     * @param status 状态 0正常 1注销
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

    /**
     * 获取会员开通时间
     *
     * @return open_time - 会员开通时间
     */
    public Date getOpenTime() {
        return openTime;
    }

    /**
     * 设置会员开通时间
     *
     * @param openTime 会员开通时间
     */
    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    /**
     * 获取推荐人姓名
     *
     * @return refereeName - 推荐人姓名
     */
    public String getRefereename() {
        return refereename;
    }

    /**
     * 设置推荐人姓名
     *
     * @param refereename 推荐人姓名
     */
    public void setRefereename(String refereename) {
        this.refereename = refereename;
    }

    /**
     * 获取推荐人手机
     *
     * @return refereePhone - 推荐人手机
     */
    public String getRefereephone() {
        return refereephone;
    }

    /**
     * 设置推荐人手机
     *
     * @param refereephone 推荐人手机
     */
    public void setRefereephone(String refereephone) {
        this.refereephone = refereephone;
    }

    /**
     * 获取会员级别
     *
     * @return level - 会员级别
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置会员级别
     *
     * @param level 会员级别
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取是否临时会员 0 是 1否
     *
     * @return isTemp - 是否临时会员 0 是 1否
     */
    public Integer getIstemp() {
        return istemp;
    }

    /**
     * 设置是否临时会员 0 是 1否
     *
     * @param istemp 是否临时会员 0 是 1否
     */
    public void setIstemp(Integer istemp) {
        this.istemp = istemp;
    }

    /**
     * 获取开通类型 1申请开通 2人工开通
     *
     * @return openType - 开通类型 1申请开通 2人工开通
     */
    public Integer getOpentype() {
        return opentype;
    }

    /**
     * 设置开通类型 1申请开通 2人工开通
     *
     * @param opentype 开通类型 1申请开通 2人工开通
     */
    public void setOpentype(Integer opentype) {
        this.opentype = opentype;
    }

    /**
     * 获取剩余金额
     *
     * @return surplusAmount - 剩余金额
     */
    public BigDecimal getSurplusamount() {
        return surplusamount;
    }

    /**
     * 设置剩余金额
     *
     * @param surplusamount 剩余金额
     */
    public void setSurplusamount(BigDecimal surplusamount) {
        this.surplusamount = surplusamount;
    }

    /**
     * 获取会员有效期截止时间
     *
     * @return validity_time - 会员有效期截止时间
     */
    public Date getValidityTime() {
        return validityTime;
    }

    /**
     * 设置会员有效期截止时间
     *
     * @param validityTime 会员有效期截止时间
     */
    public void setValidityTime(Date validityTime) {
        this.validityTime = validityTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取微信openid
     *
     * @return openid - 微信openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置微信openid
     *
     * @param openid 微信openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取微信号
     *
     * @return wxAccount - 微信号
     */
    public String getWxaccount() {
        return wxaccount;
    }

    /**
     * 设置微信号
     *
     * @param wxaccount 微信号
     */
    public void setWxaccount(String wxaccount) {
        this.wxaccount = wxaccount;
    }

    /**
     * 获取微信头像
     *
     * @return acatar - 微信头像
     */
    public String getAcatar() {
        return acatar;
    }

    /**
     * 设置微信头像
     *
     * @param acatar 微信头像
     */
    public void setAcatar(String acatar) {
        this.acatar = acatar;
    }

    /**
     * 获取验证码
     *
     * @return captcha - 验证码
     */
    public String getCaptcha() {
        return captcha;
    }

    /**
     * 设置验证码
     *
     * @param captcha 验证码
     */
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    /**
     * 获取唯一标识码
     *
     * @return idCode - 唯一标识码
     */
    public String getIdcode() {
        return idcode;
    }

    /**
     * 设置唯一标识码
     *
     * @param idcode 唯一标识码
     */
    public void setIdcode(String idcode) {
        this.idcode = idcode;
    }

    /**
     * 获取开通人用户id
     *
     * @return openUserId - 开通人用户id
     */
    public Integer getOpenuserid() {
        return openuserid;
    }

    /**
     * 设置开通人用户id
     *
     * @param openuserid 开通人用户id
     */
    public void setOpenuserid(Integer openuserid) {
        this.openuserid = openuserid;
    }

    /**
     * 获取开通人用户账号名称
     *
     * @return openUserName - 开通人用户账号名称
     */
    public String getOpenusername() {
        return openusername;
    }

    /**
     * 设置开通人用户账号名称
     *
     * @param openusername 开通人用户账号名称
     */
    public void setOpenusername(String openusername) {
        this.openusername = openusername;
    }
}