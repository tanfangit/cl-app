package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_signup_limit")
public class TSignupLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 预约限制开始时间
     */
    @Column(name = "s_time")
    private Date sTime;

    /**
     * 预约限制结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 限制对象 1 正式会员 2临时会员 3 正式加临时
     */
    @Column(name = "s_obj")
    private Integer sObj;

    /**
     * 限制类型 1 课程预约 2 其它预约
     */
    private Integer type;

    /**
     * 限制说明
     */
    private String explains;

    /**
     * 创建人id
     */
    @Column(name = "crate_userId")
    private Integer crateUserid;

    /**
     * 最后一次更新人id
     */
    @Column(name = "modify_userId")
    private Integer modifyUserid;

    /**
     * 创建时间
     */
    @Column(name = "crate_time")
    private Date crateTime;

    /**
     * 最后一次更新时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

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
     * 获取预约限制开始时间
     *
     * @return s_time - 预约限制开始时间
     */
    public Date getsTime() {
        return sTime;
    }

    /**
     * 设置预约限制开始时间
     *
     * @param sTime 预约限制开始时间
     */
    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }

    /**
     * 获取预约限制结束时间
     *
     * @return end_time - 预约限制结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置预约限制结束时间
     *
     * @param endTime 预约限制结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取限制对象 1 正式会员 2临时会员 3 正式加临时
     *
     * @return s_obj - 限制对象 1 正式会员 2临时会员 3 正式加临时
     */
    public Integer getsObj() {
        return sObj;
    }

    /**
     * 设置限制对象 1 正式会员 2临时会员 3 正式加临时
     *
     * @param sObj 限制对象 1 正式会员 2临时会员 3 正式加临时
     */
    public void setsObj(Integer sObj) {
        this.sObj = sObj;
    }

    /**
     * 获取限制类型 1 课程预约 2 其它预约
     *
     * @return type - 限制类型 1 课程预约 2 其它预约
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置限制类型 1 课程预约 2 其它预约
     *
     * @param type 限制类型 1 课程预约 2 其它预约
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取限制说明
     *
     * @return explains - 限制说明
     */
    public String getExplains() {
        return explains;
    }

    /**
     * 设置限制说明
     *
     * @param explains 限制说明
     */
    public void setExplains(String explains) {
        this.explains = explains;
    }

    /**
     * 获取创建人id
     *
     * @return crate_userId - 创建人id
     */
    public Integer getCrateUserid() {
        return crateUserid;
    }

    /**
     * 设置创建人id
     *
     * @param crateUserid 创建人id
     */
    public void setCrateUserid(Integer crateUserid) {
        this.crateUserid = crateUserid;
    }

    /**
     * 获取最后一次更新人id
     *
     * @return modify_userId - 最后一次更新人id
     */
    public Integer getModifyUserid() {
        return modifyUserid;
    }

    /**
     * 设置最后一次更新人id
     *
     * @param modifyUserid 最后一次更新人id
     */
    public void setModifyUserid(Integer modifyUserid) {
        this.modifyUserid = modifyUserid;
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
     * 获取最后一次更新时间
     *
     * @return modify_time - 最后一次更新时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置最后一次更新时间
     *
     * @param modifyTime 最后一次更新时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}