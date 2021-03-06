package com.kaini.teachingmanager.request;

import lombok.Data;

@Data
public class SelectByIdPwdRequest {
    /**
     * 登录名，不允许为空
     */
    private String loginname;

    /**
     * 密码，不允许为空
     */
    private String pwd;

}
