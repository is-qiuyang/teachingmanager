package com.kaini.teachingmanager.request;

import lombok.Data;

@Data
public class UpdataUserRequest {

    /**
     * 用户名，不允许为空
     */
    private String name;

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
     * 用户电话，不允许为空
     */
    private String mobile;

    /**
     * 性别(1-男，2-女)
     */
    private String sex;
}
