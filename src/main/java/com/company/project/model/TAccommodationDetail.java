package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_accommodation_detail")
public class TAccommodationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 基本信息
     */
    private String einfo;

    /**
     * 房型图片
     */
    private String img;

    /**
     * 房型类别 关联字典表id
     */
    private String typeid;

    /**
     * 房型类别名称
     */
    private String typename;

    /**
     * 客房设施
     */
    private String facilities;

    /**
     * 其它
     */
    private String other;

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
     * 获取基本信息
     *
     * @return einfo - 基本信息
     */
    public String getEinfo() {
        return einfo;
    }

    /**
     * 设置基本信息
     *
     * @param einfo 基本信息
     */
    public void setEinfo(String einfo) {
        this.einfo = einfo;
    }

    /**
     * 获取房型图片
     *
     * @return img - 房型图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置房型图片
     *
     * @param img 房型图片
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取房型类别 关联字典表id
     *
     * @return typeid - 房型类别 关联字典表id
     */
    public String getTypeid() {
        return typeid;
    }

    /**
     * 设置房型类别 关联字典表id
     *
     * @param typeid 房型类别 关联字典表id
     */
    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    /**
     * 获取房型类别名称
     *
     * @return typename - 房型类别名称
     */
    public String getTypename() {
        return typename;
    }

    /**
     * 设置房型类别名称
     *
     * @param typename 房型类别名称
     */
    public void setTypename(String typename) {
        this.typename = typename;
    }

    /**
     * 获取客房设施
     *
     * @return facilities - 客房设施
     */
    public String getFacilities() {
        return facilities;
    }

    /**
     * 设置客房设施
     *
     * @param facilities 客房设施
     */
    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    /**
     * 获取其它
     *
     * @return other - 其它
     */
    public String getOther() {
        return other;
    }

    /**
     * 设置其它
     *
     * @param other 其它
     */
    public void setOther(String other) {
        this.other = other;
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