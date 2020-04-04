package com.kaini.teachingmanager.service;

import com.kaini.teachingmanager.pojo.User;
import com.kaini.teachingmanager.request.UpdataUserRequest;

public interface UserService {

    //用户登录
    User selectByIdPwd(String loginname, String pwd);

    //用户注册
    Integer insertUser(User user);

    int updateLastLoginTime(User user);

    Integer DeleteUserById(Long id);

    boolean updateUserById(UpdataUserRequest userRequest);

    User selectById(Long id);
}
