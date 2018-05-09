package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_course")
public class TCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 课程图片地址
     */
    private String img;

    /**
     * 课程开始时间
     */
    @Column(name = "sTime")
    private Date stime;

    /**
     * 总课时
     */
    @Column(name = "cHour")
    private Integer chour;

    /**
     * 总报名人数
     */
    @Column(name = "aCount")
    private Integer acount;

    /**
     * 报名最大人数
     */
    private Integer count;

    /**
     * 讲师名称
     */
    @Column(name = "tName")
    private String tname;

    /**
     * 讲师id
     */
    @Column(name = "tId")
    private Integer tid;

    /**
     * 课程分类id
     */
    @Column(name = "typeId")
    private Integer typeid;

    /**
     * 课程简介
     */
    private String datail;

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
     * 获取课程名称
     *
     * @return name - 课程名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置课程名称
     *
     * @param name 课程名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取课程图片地址
     *
     * @return img - 课程图片地址
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置课程图片地址
     *
     * @param img 课程图片地址
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取课程开始时间
     *
     * @return sTime - 课程开始时间
     */
    public Date getStime() {
        return stime;
    }

    /**
     * 设置课程开始时间
     *
     * @param stime 课程开始时间
     */
    public void setStime(Date stime) {
        this.stime = stime;
    }

    /**
     * 获取总课时
     *
     * @return cHour - 总课时
     */
    public Integer getChour() {
        return chour;
    }

    /**
     * 设置总课时
     *
     * @param chour 总课时
     */
    public void setChour(Integer chour) {
        this.chour = chour;
    }

    /**
     * 获取总报名人数
     *
     * @return aCount - 总报名人数
     */
    public Integer getAcount() {
        return acount;
    }

    /**
     * 设置总报名人数
     *
     * @param acount 总报名人数
     */
    public void setAcount(Integer acount) {
        this.acount = acount;
    }

    /**
     * 获取报名最大人数
     *
     * @return count - 报名最大人数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置报名最大人数
     *
     * @param count 报名最大人数
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取讲师名称
     *
     * @return tName - 讲师名称
     */
    public String getTname() {
        return tname;
    }

    /**
     * 设置讲师名称
     *
     * @param tname 讲师名称
     */
    public void setTname(String tname) {
        this.tname = tname;
    }

    /**
     * 获取讲师id
     *
     * @return tId - 讲师id
     */
    public Integer getTid() {
        return tid;
    }

    /**
     * 设置讲师id
     *
     * @param tid 讲师id
     */
    public void setTid(Integer tid) {
        this.tid = tid;
    }

    /**
     * 获取课程分类id
     *
     * @return typeId - 课程分类id
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * 设置课程分类id
     *
     * @param typeid 课程分类id
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * 获取课程简介
     *
     * @return datail - 课程简介
     */
    public String getDatail() {
        return datail;
    }

    /**
     * 设置课程简介
     *
     * @param datail 课程简介
     */
    public void setDatail(String datail) {
        this.datail = datail;
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
}