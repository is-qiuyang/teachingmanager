package com.kaini.teachingmanager.dao;


import com.kaini.teachingmanager.mapper.UserMapper;
import com.kaini.teachingmanager.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;


    //根据ID和密码查询用户是否存在，是否登录
    public List<User> selectIdentityByIdPwd(String loginname, String pwd){

        Example userExample = new Example(User.class);
        userExample.createCriteria().andEqualTo(loginname).andEqualTo(pwd);
        //去重
        userExample.setDistinct(true);
        return userMapper.selectByExample(userExample);
    }

    //用户注册
    public Integer insertUser(User user){
        return userMapper.insert(user);
    }

    //更新最后登录时间
    public int updateLastLoginTime(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    //更新头像
    public int updateImg(User user){
        return userMapper.updateByPrimaryKey(user);
    }
}
