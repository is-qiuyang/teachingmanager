package com.kaini.teachingmanager.dao;


import com.kaini.teachingmanager.mapper.UserMapper;
import com.kaini.teachingmanager.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
@Slf4j
public class UserDao {
    @Autowired
    private UserMapper userMapper;


    //根据ID和密码查询用户是否存在，是否登录
    public List<User> selectIdentityByIdPwd(String loginname, String pwd){

        Example userExample = new Example(User.class);
        userExample.createCriteria().andEqualTo("loginname",loginname).andEqualTo("pwd",pwd);
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

    /**
     * 方法描述
     * @ 用户注销
     * @return
     * @date 2020/2/12
     */
    public Integer DeleteUserByName(String name) {
        Example userExample = new Example(User.class);
        userExample.createCriteria().andEqualTo("name",name);
        return userMapper.deleteByExample(userExample);
    }

    /**
     * 方法描述
     * @ 查询所有用户
     * @return
     * @date 2020/2/12
     */
    public List<User> selectAllUser() {
        return userMapper.selectAll();
    }


    /**
     * 方法描述
     * @ 批量删除
     * @return
     * @date 2020/2/12
     */
    public int deleteAllUser(List<Long> ids) {
        Example userExample = new Example(User.class);
        userExample.createCriteria().andIn("id",ids);
        return userMapper.deleteByExample(userExample);
    }

    public User selectSomeUser(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public boolean updateUserById(User user) {
        Example userExample = new Example(User.class);
        userExample.createCriteria().andEqualTo("id",user.getId());
        if(userMapper.updateByExampleSelective(user,userExample)==1){
            return true;
        }else {
            return false;
        }
    }
}
