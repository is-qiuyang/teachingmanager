package com.kaini.teachingmanager.controller;

import com.kaini.teachingmanager.pojo.User;
import com.kaini.teachingmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //用户登录
    @GetMapping("selectByIdPwd/user")
    public String selectByIdPwd(String loginname, String pwd){

        User user = userService.selectByIdPwd(loginname, pwd);
        if(user==null){
            return "用户不存在或账号密码错误";
        }else {
            user.setLastlogintime(new Date());
            userService.updateLastLoginTime(user);
            Short identity = user.getIdentity();
            //System.out.println(user.toString());
            if (identity == 0) {
                return "管理员登录";
            } else if (identity == 2) {
                return "教师登录";
            } else if (identity == 1) {
                return "学生登录";
            } else {
                return "身份验证失败请重新登录";
            }
        }
    }

    //用户注册
    @PostMapping("add/user")
    public String insertUser(User user){
        user.setCreatetime(new Date());
        user.setLastlogintime(new Date());
        if (userService.insertUser(user).equals(1)){
            return "注册成功";
        }else {
            return "注册失败，请重新注册";
        }
    }
}
