package com.kaini.teachingmanager.request;

public class AddUserRequest {
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
    private Long enrollmenttime;

    /**
     * 用户电话，不允许为空
     */
    private String mobile;


    /**
     * 身份验证(1-学生，0-管理员，2-老师)，不允许为空
     */
    private Short identity;

    /**
     * 性别(1-男，2-女)
     */
    private String sex;

    public void setName(String name) {
        this.name = name;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnrollmenttime(Long enrollmenttime) {
        this.enrollmenttime = enrollmenttime;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setIdentity(Short identity) {
        this.identity = identity;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getLoginname() {
        return loginname;
    }

    public String getPwd() {
        return pwd;
    }

    public String getImg() {
        return img;
    }

    public String getEmail() {
        return email;
    }

    public Long getEnrollmenttime() {
        return enrollmenttime;
    }

    public String getMobile() {
        return mobile;
    }

    public Short getIdentity() {
        return identity;
    }

    public String getSex() {
        return sex;
    }
}
