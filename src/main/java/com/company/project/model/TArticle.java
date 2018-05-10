package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_article")
public class TArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 发布对象 1 正式会员 2临时会员 3正式加临时 4游客
     */
    private Integer robj;

    /**
     * 标题
     */
    private String title;

    /**
     * 排序
     */
    private Integer orders;

    /**
     * 发布时间
     */
    @Column(name = "r_time")
    private Date rTime;

    /**
     * 截止时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 摘要
     */
    private String abstracts;

    /**
     * 图片
     */
    private String img;

    /**
     * 创建时间
     */
    @Column(name = "crate_time")
    private Date crateTime;

    /**
     * 图文描述
     */
    private String context;

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
     * 获取发布对象 1 正式会员 2临时会员 3正式加临时 4游客
     *
     * @return robj - 发布对象 1 正式会员 2临时会员 3正式加临时 4游客
     */
    public Integer getRobj() {
        return robj;
    }

    /**
     * 设置发布对象 1 正式会员 2临时会员 3正式加临时 4游客
     *
     * @param robj 发布对象 1 正式会员 2临时会员 3正式加临时 4游客
     */
    public void setRobj(Integer robj) {
        this.robj = robj;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取排序
     *
     * @return order - 排序
     */
    public Integer getOrders() {
        return orders;
    }

    /**
     * 设置排序
     *
     * @param order 排序
     */
    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    /**
     * 获取发布时间
     *
     * @return r_time - 发布时间
     */
    public Date getrTime() {
        return rTime;
    }

    /**
     * 设置发布时间
     *
     * @param rTime 发布时间
     */
    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }

    /**
     * 获取截止时间
     *
     * @return end_time - 截止时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置截止时间
     *
     * @param endTime 截止时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取摘要
     *
     * @return abstract - 摘要
     */
    public String getAbstracts() {
        return abstracts;
    }

    /**
     * 设置摘要
     *
     * @param abstract 摘要
     */
    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    /**
     * 获取图片
     *
     * @return img - 图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置图片
     *
     * @param img 图片
     */
    public void setImg(String img) {
        this.img = img;
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
     * 获取图文描述
     *
     * @return context - 图文描述
     */
    public String getContext() {
        return context;
    }

    /**
     * 设置图文描述
     *
     * @param context 图文描述
     */
    public void setContext(String context) {
        this.context = context;
    }
}