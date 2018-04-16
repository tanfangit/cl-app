package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户工号
     */
    @Column(name = "user_no")
    private Long userNo;

    /**
     * 用户真实姓名
     */
    private String name;

    /**
     * 登录名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 所属部门
     */
    private String dept;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态  0：禁用   1：正常  2：删除
     */
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 更新人
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 工作年限
     */
    @Column(name = "work_year")
    private Integer workYear;

    /**
     * 职位
     */
    @Column(name = "user_position")
    private String userPosition;

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户工号
     *
     * @return user_no - 用户工号
     */
    public Long getUserNo() {
        return userNo;
    }

    /**
     * 设置用户工号
     *
     * @param userNo 用户工号
     */
    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    /**
     * 获取用户真实姓名
     *
     * @return name - 用户真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户真实姓名
     *
     * @param name 用户真实姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取登录名
     *
     * @return username - 登录名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置登录名
     *
     * @param username 登录名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取盐
     *
     * @return salt - 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐
     *
     * @param salt 盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取所属部门
     *
     * @return dept - 所属部门
     */
    public String getDept() {
        return dept;
    }

    /**
     * 设置所属部门
     *
     * @param dept 所属部门
     */
    public void setDept(String dept) {
        this.dept = dept;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取状态  0：禁用   1：正常  2：删除
     *
     * @return status - 状态  0：禁用   1：正常  2：删除
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态  0：禁用   1：正常  2：删除
     *
     * @param status 状态  0：禁用   1：正常  2：删除
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人
     *
     * @return create_user - 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人
     *
     * @param createUser 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取更新人
     *
     * @return update_user - 更新人
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置更新人
     *
     * @param updateUser 更新人
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取工作年限
     *
     * @return work_year - 工作年限
     */
    public Integer getWorkYear() {
        return workYear;
    }

    /**
     * 设置工作年限
     *
     * @param workYear 工作年限
     */
    public void setWorkYear(Integer workYear) {
        this.workYear = workYear;
    }

    /**
     * 获取职位
     *
     * @return user_position - 职位
     */
    public String getUserPosition() {
        return userPosition;
    }

    /**
     * 设置职位
     *
     * @param userPosition 职位
     */
    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }
}