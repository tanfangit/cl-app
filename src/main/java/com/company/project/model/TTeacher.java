package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_teacher")
public class TTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 讲师名称
     */
    private String name;

    /**
     * 讲师图片地址
     */
    private String img;

    /**
     * 讲师详细介绍
     */
    private String detail;
    
    private Integer typeId;
    

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
     * 获取讲师名称
     *
     * @return name - 讲师名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置讲师名称
     *
     * @param name 讲师名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取讲师图片地址
     *
     * @return img - 讲师图片地址
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置讲师图片地址
     *
     * @param img 讲师图片地址
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取讲师详细介绍
     *
     * @return detail - 讲师详细介绍
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置讲师详细介绍
     *
     * @param detail 讲师详细介绍
     */
    public void setDetail(String detail) {
        this.detail = detail;
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

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
    
}