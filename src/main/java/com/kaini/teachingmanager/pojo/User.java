package com.kaini.teachingmanager.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "teaching_user")
public class User {
    /**
     * 用户编号，定义为主键，自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名，不允许为空
     */
    private String name;

    /**
     * 登录名，不允许为空
     */
    private String loginname;

    /**
     * 密码，不允许为空
     */
    private String pwd;

    /**
     * 用户照片，不允许为空
     */
    private String img;

    /**
     * 用户邮箱，不允许为空
     */
    private String email;

    /**
     * 入学时间，不允许为空
     */
    private String enrollmenttime;

    /**
     * 用户电话，不允许为空
     */
    private String mobile;

    /**
     * 创建时间，不允许为空
     */
    private Date createtime;

    /**
     * 最后登录时间，不允许为空
     */
    private Date lastlogintime;

    /**
     * 身份验证(1-学生，0-管理员，2-老师)，不允许为空
     */
    private Short identity;

    /**
     * 性别(1-男，2-女)
     */
    private String sex;

    /**
     * 获取用户编号，定义为主键，自动编号
     *
     * @return id - 用户编号，定义为主键，自动编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置用户编号，定义为主键，自动编号
     *
     * @param id 用户编号，定义为主键，自动编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户名，不允许为空
     *
     * @return name - 用户名，不允许为空
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名，不允许为空
     *
     * @param name 用户名，不允许为空
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取登录名，不允许为空
     *
     * @return loginname - 登录名，不允许为空
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * 设置登录名，不允许为空
     *
     * @param loginname 登录名，不允许为空
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    /**
     * 获取密码，不允许为空
     *
     * @return pwd - 密码，不允许为空
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置密码，不允许为空
     *
     * @param pwd 密码，不允许为空
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * 获取用户照片，不允许为空
     *
     * @return img - 用户照片，不允许为空
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置用户照片，不允许为空
     *
     * @param img 用户照片，不允许为空
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * 获取用户邮箱，不允许为空
     *
     * @return email - 用户邮箱，不允许为空
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置用户邮箱，不允许为空
     *
     * @param email 用户邮箱，不允许为空
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取入学时间，不允许为空
     *
     * @return enrollmenttime - 入学时间，不允许为空
     */
    public String getEnrollmenttime() {
        return enrollmenttime;
    }

    /**
     * 设置入学时间，不允许为空
     *
     * @param enrollmenttime 入学时间，不允许为空
     */
    public void setEnrollmenttime(String enrollmenttime) {
        this.enrollmenttime = enrollmenttime == null ? null : enrollmenttime.trim();
    }

    /**
     * 获取用户电话，不允许为空
     *
     * @return mobile - 用户电话，不允许为空
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置用户电话，不允许为空
     *
     * @param mobile 用户电话，不允许为空
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取创建时间，不允许为空
     *
     * @return createtime - 创建时间，不允许为空
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间，不允许为空
     *
     * @param createtime 创建时间，不允许为空
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取最后登录时间，不允许为空
     *
     * @return lastlogintime - 最后登录时间，不允许为空
     */
    public Date getLastlogintime() {
        return lastlogintime;
    }

    /**
     * 设置最后登录时间，不允许为空
     *
     * @param lastlogintime 最后登录时间，不允许为空
     */
    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    /**
     * 获取身份验证(1-学生，0-管理员，2-老师)，不允许为空
     *
     * @return identity - 身份验证(1-学生，0-管理员，2-老师)，不允许为空
     */
    public Short getIdentity() {
        return identity;
    }

    /**
     * 设置身份验证(1-学生，0-管理员，2-老师)，不允许为空
     *
     * @param identity 身份验证(1-学生，0-管理员，2-老师)，不允许为空
     */
    public void setIdentity(Short identity) {
        this.identity = identity;
    }

    /**
     * 获取性别(1-男，2-女)
     *
     * @return sex - 性别(1-男，2-女)
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别(1-男，2-女)
     *
     * @param sex 性别(1-男，2-女)
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
}