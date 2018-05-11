package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_restaurant_detail")
public class TRestaurantDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 菜品名称
     */
    private String name;

    /**
     * 菜品图片
     */
    private String img;

    /**
     * 菜品类别 关联字典表id
     */
    private String typeid;

    /**
     * 菜品类别名称
     */
    private String typename;

    /**
     * 介绍说明
     */
    private String context;

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
     * 获取菜品名称
     *
     * @return name - 菜品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜品名称
     *
     * @param name 菜品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取菜品图片
     *
     * @return img - 菜品图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置菜品图片
     *
     * @param img 菜品图片
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取菜品类别 关联字典表id
     *
     * @return typeid - 菜品类别 关联字典表id
     */
    public String getTypeid() {
        return typeid;
    }

    /**
     * 设置菜品类别 关联字典表id
     *
     * @param typeid 菜品类别 关联字典表id
     */
    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    /**
     * 获取菜品类别名称
     *
     * @return typename - 菜品类别名称
     */
    public String getTypename() {
        return typename;
    }

    /**
     * 设置菜品类别名称
     *
     * @param typename 菜品类别名称
     */
    public void setTypename(String typename) {
        this.typename = typename;
    }

    /**
     * 获取介绍说明
     *
     * @return context - 介绍说明
     */
    public String getContext() {
        return context;
    }

    /**
     * 设置介绍说明
     *
     * @param context 介绍说明
     */
    public void setContext(String context) {
        this.context = context;
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