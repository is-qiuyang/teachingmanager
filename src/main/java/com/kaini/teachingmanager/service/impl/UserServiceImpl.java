package com.kaini.teachingmanager.service.impl;


import com.kaini.teachingmanager.dao.UserDao;
import com.kaini.teachingmanager.pojo.User;
import com.kaini.teachingmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    //根据ID和密码查询用户是否存在，用户登录
    @Override
    public User selectByIdPwd(String loginname, String pwd) {
        List<User> users = userDao.selectIdentityByIdPwd(loginname, pwd);
        for (User userList:users) {
            if(userList.getLoginname().equals(loginname) && userList.getPwd().equals(pwd)){
                return userList;
            }
        }
        return null;

    }

    //用户注册
    @Override
    public Integer insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int updateLastLoginTime(User user) {
        return userDao.updateLastLoginTime(user);
    }


}
