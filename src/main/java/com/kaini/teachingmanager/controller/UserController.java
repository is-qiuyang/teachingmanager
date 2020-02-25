package com.kaini.teachingmanager.controller;

import com.kaini.teachingmanager.pojo.User;
import com.kaini.teachingmanager.request.AddUserRequest;
import com.kaini.teachingmanager.request.SelectByIdPwdRequest;
import com.kaini.teachingmanager.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    //用户登录
    @ApiOperation(value = "用户登录")
    @PostMapping("selectByIdPwd/user")
    @ResponseBody
    public String selectByIdPwd(HttpServletRequest request, SelectByIdPwdRequest idPwdRequest){

        User user = userService.selectByIdPwd(idPwdRequest.getLoginname(), idPwdRequest.getPwd());
        //如果用户不为空，判断身份，并将用户信息存入session
        if(user==null){
            return  "用户不存在或账号密码错误";
        }else {
            user.setLastlogintime(new Date());
            userService.updateLastLoginTime(user);
            //用户存在加入session
            request.getSession().setAttribute("idPwdRequest",idPwdRequest);
            log.info("session"+request.toString());
            //身份判断
            Short identity = user.getIdentity();
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
    @ApiOperation(value = "用户注册")
    @PostMapping("add/user")
    public String insertUser(@RequestBody AddUserRequest userRequest){

        if (userService.insertUser(userRequest).equals(1)){
            return "注册成功";
        }else {
            return "注册失败，请重新注册";
        }
    }

    /**
     * 方法描述
     * @ 用户退出登录，用session进行操作
     * @return
     * @date 2020/2/12
     */
    @ApiOperation(value = "用户退出登录，用session进行操作")
    @DeleteMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("idPwdRequest");
        return "退出登录";
    }
    
    /**
     * 方法描述
     * @ 用户注销
     * @return 
     * @date 2020/2/12
     */
    @ApiOperation(value = "用户注销")
    @DeleteMapping(value = "Delete/User/By/Nike_Name")
    public String DeleteUserByNikeName(@RequestBody String name){
        Integer integer = userService.DeleteUserByName(name);
        if(integer>=1){
            return "删除成功";
        }else {
            return "用户不存在";
        }
    }
}
