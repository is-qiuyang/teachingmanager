package com.kaini.teachingmanager.service;

import com.kaini.teachingmanager.pojo.User;

public interface UserService {

    //用户登录
    User selectByIdPwd(String loginname, String pwd);

    //用户注册
    Integer insertUser(User user);

    int updateLastLoginTime(User user);

}
