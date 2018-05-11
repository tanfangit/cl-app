package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_experience_detail")
public class TExperienceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 体验项目名称
     */
    private String name;

    /**
     * 体验时长
     */
    private String time;

    /**
     * 图片或者视频资源地址
     */
    private String img;

    /**
     * 介绍说明
     */
    private String explains;

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
     * 获取体验项目名称
     *
     * @return name - 体验项目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置体验项目名称
     *
     * @param name 体验项目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取体验时长
     *
     * @return time - 体验时长
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置体验时长
     *
     * @param time 体验时长
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取图片或者视频资源地址
     *
     * @return img - 图片或者视频资源地址
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置图片或者视频资源地址
     *
     * @param img 图片或者视频资源地址
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取介绍说明
     *
     * @return explain - 介绍说明
     */
    public String getExplains() {
        return explains;
    }

    /**
     * 设置介绍说明
     *
     * @param explain 介绍说明
     */
    public void setExplains(String explains) {
        this.explains = explains;
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