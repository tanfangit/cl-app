package com.company.project.model;

import javax.persistence.*;

@Table(name = "t_course_type")
public class TCourseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 课程分类名称
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
     * 获取课程分类名称
     *
     * @return name - 课程分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置课程分类名称
     *
     * @param name 课程分类名称
     */
    public void setName(String name) {
        this.name = name;
    }
}