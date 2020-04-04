package com.kaini.teachingmanager.controller;

import com.kaini.teachingmanager.annotation.UnInterception;
import com.kaini.teachingmanager.common.SzpJsonResult;
import com.kaini.teachingmanager.pojo.User;
import com.kaini.teachingmanager.request.*;
import com.kaini.teachingmanager.response.SelectByIdPwdResponse;
import com.kaini.teachingmanager.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    //用户登录
    @UnInterception
    @ApiOperation(value = "用户登录")
    @PostMapping("login")
    public SzpJsonResult<SelectByIdPwdResponse> selectByIdPwd(HttpServletResponse response, @RequestBody SelectByIdPwdRequest idPwdRequest) {

        //TokenUtil tokenUtil = new TokenUtil();
        User user = userService.selectByIdPwd(idPwdRequest.getLoginname(), idPwdRequest.getPwd());

        //如果用户不为空，并将用户信息创建为token，存入Redis，判断身份
        if (user == null) {
            return SzpJsonResult.errorMsg("用户不存在或账号密码错误");
        }
        //登陆成功后生成了一个token
        String token = UUID.randomUUID().toString();
        log.info("requestToken-{}", token);
        // 将token存入Redis中,5分钟过期
        stringRedisTemplate.opsForValue().set(user.getLoginname(),token);
        stringRedisTemplate.expire(user.getLoginname(),60*60*50,TimeUnit.SECONDS);
        stringRedisTemplate.opsForValue().set(token,user.getLoginname());
        stringRedisTemplate.expire(user.getLoginname(),60*60*50,TimeUnit.SECONDS);
        Long currentTime = System.currentTimeMillis();
        stringRedisTemplate.opsForValue().set(token + user.getLoginname(),currentTime.toString());

        response.setHeader("token",token);
        SelectByIdPwdResponse pwdResponse = new SelectByIdPwdResponse();
        BeanUtils.copyProperties(user,pwdResponse);

        return SzpJsonResult.ok(pwdResponse);
    }

    //用户注册
    @UnInterception
    @ApiOperation(value = "用户注册")
    @PostMapping("add/user")
    public SzpJsonResult<String> insertUser(@RequestBody AddUserRequest userRequest){
        User user = new User();
        BeanUtils.copyProperties(userRequest,user);
        user.setCreatetime(new Date());

        String token = stringRedisTemplate.opsForValue().get(userRequest.getLoginname());
        log.info("insertRequestToken-{}", token);
        //判断用户名是否重复
        log.info("addUserToken-{}", token);
        if(token != null){
            return SzpJsonResult.errorMsg("用户名重复，请更改用户名");
        }
        if (userService.insertUser(user).equals(1)){
            return SzpJsonResult.ok("注册成功");
        }else {
            return SzpJsonResult.errorMsg("注册失败，请重新注册");
        }
    }

    /**
     * 方法描述
     * @ 用户退出登录，用session进行操作
     * @return
     * @date 2020/2/12
     */
    @ApiOperation(value = "用户退出登录，用session进行操作")
    @PostMapping("/logout")
    public SzpJsonResult<String> logout(HttpServletRequest request, @RequestBody LogoutRequest logoutRequest){
        stringRedisTemplate.delete(request.getHeader("token"));
        stringRedisTemplate.delete(logoutRequest.getLoginname());
        stringRedisTemplate.delete(request.getHeader("token")+logoutRequest.getLoginname());
        return SzpJsonResult.ok("退出登录");
    }

    /**
     * 方法描述
     * @ 用户注销
     * @return
     * @date 2020/2/12
     */
    @ApiOperation(value = "用户注销")
    @PostMapping(value = "delete/user")
    public SzpJsonResult<String> deleteUserById(@RequestBody DeleteUserByNikeNameRequest request){
        Integer integer = userService.DeleteUserById(request.getId());
        if(integer>=1){
            return SzpJsonResult.ok("删除成功");
        }else {
            return SzpJsonResult.errorMsg("用户不存在");
        }
    }

    /**
     * 方法描述
     * @ 更改用户信息
     * @return
     * @date 2020/2/25
     */
    @ApiOperation(value = "更改用户信息")
    @PostMapping("updata/user")
    public SzpJsonResult<String> updateById(@RequestBody UpdataUserRequest userRequest) {
        boolean isSuccess = userService.updateUserById(userRequest);
        return SzpJsonResult.ok(isSuccess);
    }

    /**
     * 方法描述
     * @ 得到用户信息
     * @return
     * @date 2020/3/31
     */
    @ApiOperation(value = "查看用户信息")
    @PostMapping("select/user")
    public User selectById(@RequestBody SelectByIdRequest request) {
        User user = userService.selectById(request.getId());
        return user;
    }
}
