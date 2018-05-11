package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_antique_detail")
public class TAntiqueDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文玩首页Id
     */
    private Integer aid;

    /**
     * 文玩名称
     */
    private String name;

    /**
     * 材质
     */
    private String material;

    /**
     * 类别id
     */
    private Integer typeid;

    
    /**
     * 来源id
     */
    private Integer sid;
    /**
     * 年代
     */
    private String year;

    /**
     * 编号
     */
    private String number;

    /**
     * 图片地址
     */
    private String img;
    
    /**
     * 物品尺寸
     */
    private String sizes;
    /**
     * 物品重量
     */
    private String weights;
    /**
     * 介绍说明
     */
    private String explains;
    
    /**
     * 创建时间
     */
    @Column(name = "crate_time")
    private Date crateTime;
    
    
    public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public String getWeights() {
		return weights;
	}

	public void setWeights(String weights) {
		this.weights = weights;
	}

	public String getExplains() {
		return explains;
	}

	public void setExplains(String explains) {
		this.explains = explains;
	}

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
     * 获取文玩首页Id
     *
     * @return aid - 文玩首页Id
     */
    public Integer getAid() {
        return aid;
    }

    /**
     * 设置文玩首页Id
     *
     * @param aid 文玩首页Id
     */
    public void setAid(Integer aid) {
        this.aid = aid;
    }

    /**
     * 获取文玩名称
     *
     * @return name - 文玩名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置文玩名称
     *
     * @param name 文玩名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取材质
     *
     * @return material - 材质
     */
    public String getMaterial() {
        return material;
    }

    /**
     * 设置材质
     *
     * @param material 材质
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * 获取类别id
     *
     * @return typeid - 类别id
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * 设置类别id
     *
     * @param typeid 类别id
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	/**
     * 获取年代
     *
     * @return year - 年代
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置年代
     *
     * @param year 年代
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取编号
     *
     * @return number - 编号
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置编号
     *
     * @param number 编号
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 获取图片地址
     *
     * @return img - 图片地址
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置图片地址
     *
     * @param img 图片地址
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
}