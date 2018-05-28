package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_antique_detail_job")
public class TAntiqueDetailJob {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 定时任务开始时间
     */
    private Date sdate;

    /**
     * 定时任务结束时间
     */
    private Date edate;

    /**
     * 0 同步未完成 1同步完成
     */
    private Integer status;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取定时任务开始时间
     *
     * @return sdate - 定时任务开始时间
     */
    public Date getSdate() {
        return sdate;
    }

    /**
     * 设置定时任务开始时间
     *
     * @param sdate 定时任务开始时间
     */
    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    /**
     * 获取定时任务结束时间
     *
     * @return edate - 定时任务结束时间
     */
    public Date getEdate() {
        return edate;
    }

    /**
     * 设置定时任务结束时间
     *
     * @param edate 定时任务结束时间
     */
    public void setEdate(Date edate) {
        this.edate = edate;
    }

    /**
     * 获取0 同步未完成 1同步完成
     *
     * @return status - 0 同步未完成 1同步完成
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0 同步未完成 1同步完成
     *
     * @param status 0 同步未完成 1同步完成
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}