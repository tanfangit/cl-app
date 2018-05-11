package com.company.project.model;

import javax.persistence.*;

@Table(name = "t_antique_source")
public class TAntiqueSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文玩来源名称
     */
    private String name;

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
     * 获取文玩来源名称
     *
     * @return name - 文玩来源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置文玩来源名称
     *
     * @param name 文玩来源名称
     */
    public void setName(String name) {
        this.name = name;
    }
}