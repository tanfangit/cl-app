package com.company.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "t_restaurant_banner")
public class TRestaurantBanner {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
    /**
     * 文玩首页Id
     */
    private Integer eid;

    /**
     * 发布对象 1 会员 2临时会员 3全部
     */
    private Integer robj;

    /**
     * 标题
     */
    private String title;

    /**
     * 状态 0 不启用 1 启用
     */
    private Integer status;

    /**
     * 图片或者视频资源地址
     */
    @Column(name = "resUrl")
    private String resurl;

    /**
     * 资源类型 1 图片 2 视频
     */
    private Integer types;

    /**
     * 发布人id 0 不启用 1 启用
     */
    @Column(name = "cUserId")
    private Integer cuserid;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
     * 发布人用户账号名称
     */
    @Column(name = "cUserName")
    private String cusername;
    
    /**
     * 
     */
    @Column(name = "previewImg")
    private String previewImg;

    /**
     * 创建时间
     */
    @Column(name = "crate_time")
    private Date crateTime;
    
    public String getPreviewImg() {
		return previewImg;
	}

	public void setPreviewImg(String previewImg) {
		this.previewImg = previewImg;
	}

	/**
     * 获取文玩首页Id
     *
     * @return aid - 文玩首页Id
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * 设置文玩首页Id
     *
     * @param aid 文玩首页Id
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * 获取发布对象 1 会员 2临时会员 3全部
     *
     * @return robj - 发布对象 1 会员 2临时会员 3全部
     */
    public Integer getRobj() {
        return robj;
    }

    /**
     * 设置发布对象 1 会员 2临时会员 3全部
     *
     * @param robj 发布对象 1 会员 2临时会员 3全部
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
     * 获取状态 0 不启用 1 启用
     *
     * @return status - 状态 0 不启用 1 启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0 不启用 1 启用
     *
     * @param status 状态 0 不启用 1 启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取图片或者视频资源地址
     *
     * @return resUrl - 图片或者视频资源地址
     */
    public String getResurl() {
        return resurl;
    }

    /**
     * 设置图片或者视频资源地址
     *
     * @param resurl 图片或者视频资源地址
     */
    public void setResurl(String resurl) {
        this.resurl = resurl;
    }

    /**
     * 获取资源类型 1 图片 2 视频
     *
     * @return types - 资源类型 1 图片 2 视频
     */
    public Integer getTypes() {
        return types;
    }

    /**
     * 设置资源类型 1 图片 2 视频
     *
     * @param types 资源类型 1 图片 2 视频
     */
    public void setTypes(Integer types) {
        this.types = types;
    }

    /**
     * 获取发布人id 0 不启用 1 启用
     *
     * @return cUserId - 发布人id 0 不启用 1 启用
     */
    public Integer getCuserid() {
        return cuserid;
    }

    /**
     * 设置发布人id 0 不启用 1 启用
     *
     * @param cuserid 发布人id 0 不启用 1 启用
     */
    public void setCuserid(Integer cuserid) {
        this.cuserid = cuserid;
    }

    /**
     * 获取发布人用户账号名称
     *
     * @return cUserName - 发布人用户账号名称
     */
    public String getCusername() {
        return cusername;
    }

    /**
     * 设置发布人用户账号名称
     *
     * @param cusername 发布人用户账号名称
     */
    public void setCusername(String cusername) {
        this.cusername = cusername;
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
