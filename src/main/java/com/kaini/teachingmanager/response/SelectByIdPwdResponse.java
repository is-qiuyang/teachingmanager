package com.kaini.teachingmanager.response;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class SelectByIdPwdResponse {
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

}
