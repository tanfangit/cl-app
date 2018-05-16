package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_collections")
public class TCollections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 会员id
     */
    private Integer mid;

    /**
     * 收藏类型 1 课程 2文玩 3体验 4餐饮 5 住宿
     */
    private Integer type;

    /**
     * 收藏的id 比如课程id
     */
    private Integer cid;

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
     * 获取会员id
     *
     * @return mid - 会员id
     */
    public Integer getMid() {
        return mid;
    }

    /**
     * 设置会员id
     *
     * @param mid 会员id
     */
    public void setMid(Integer mid) {
        this.mid = mid;
    }

    /**
     * 获取收藏类型 1 课程 2文玩 3体验 4餐饮 5 住宿
     *
     * @return type - 收藏类型 1 课程 2文玩 3体验 4餐饮 5 住宿
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置收藏类型 1 课程 2文玩 3体验 4餐饮 5 住宿
     *
     * @param type 收藏类型 1 课程 2文玩 3体验 4餐饮 5 住宿
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取收藏的id 比如课程id
     *
     * @return cid - 收藏的id 比如课程id
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * 设置收藏的id 比如课程id
     *
     * @param cid 收藏的id 比如课程id
     */
    public void setCid(Integer cid) {
        this.cid = cid;
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