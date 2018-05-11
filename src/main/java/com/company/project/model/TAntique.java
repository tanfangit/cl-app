package com.company.project.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Table(name = "t_antique")
public class TAntique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文玩馆类型 1 大象国际文玩 2莫干山文玩
     */
    private Integer type;

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
     * 获取文玩馆类型 1 大象国际文玩 2莫干山文玩
     *
     * @return type - 文玩馆类型 1 大象国际文玩 2莫干山文玩
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置文玩馆类型 1 大象国际文玩 2莫干山文玩
     *
     * @param type 文玩馆类型 1 大象国际文玩 2莫干山文玩
     */
    public void setType(Integer type) {
        this.type = type;
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