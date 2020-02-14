package com.kaini.teachingmanager.service;

import com.kaini.teachingmanager.pojo.User;
import com.kaini.teachingmanager.request.AddUserRequest;

public interface UserService {

    //用户登录
    User selectByIdPwd(String loginname, String pwd);

    //用户注册
    Integer insertUser(AddUserRequest userRequest);

    int updateLastLoginTime(User user);

    Integer DeleteUserByName(String name);
}
