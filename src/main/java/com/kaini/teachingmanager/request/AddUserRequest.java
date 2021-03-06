package com.kaini.teachingmanager.request;

import lombok.Data;

@Data
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


}
