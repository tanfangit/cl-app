package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_antique_type")
public class TAntiqueType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文玩类型名称
     */
    private String name;

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
     * 获取文玩类型名称
     *
     * @return name - 文玩类型名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置文玩类型名称
     *
     * @param name 文玩类型名称
     */
    public void setName(String name) {
        this.name = name;
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