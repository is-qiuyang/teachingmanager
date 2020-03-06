package com.kaini.teachingmanager.controller;

import com.kaini.teachingmanager.annotation.UnInterception;
import com.kaini.teachingmanager.common.SzpJsonResult;
import com.kaini.teachingmanager.pojo.User;
import com.kaini.teachingmanager.request.AddUserRequest;
import com.kaini.teachingmanager.request.SelectByIdPwdRequest;
import com.kaini.teachingmanager.request.UpdataUserRequest;
import com.kaini.teachingmanager.service.UserService;
import com.kaini.teachingmanager.service.impl.TokenServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenServiceImpl tokenService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //用户登录
    @UnInterception
    @ApiOperation(value = "用户登录")
    @PostMapping("login")
    public String selectByIdPwd(HttpServletRequest request, @RequestBody SelectByIdPwdRequest idPwdRequest) {

        //User user = userService.selectByIdPwd(idPwdRequest.getLoginname(), idPwdRequest.getPwd());
        User user = new User();
        BeanUtils.copyProperties(idPwdRequest, user);
        user.setLastlogintime(new Date());
        userService.updateLastLoginTime(user);

        //如果用户不为空，判断身份，并将用户信息创建为token，存入Redis
        if (user == null) {
            return "用户不存在或账号密码错误";
        }
        //从request header里面取得token
        String token = request.getHeader("token");
        log.info("requestToken-{}", token);
        //从Redis里面取得token
        String value = stringRedisTemplate.opsForValue().get("token");
        log.info("redistoken:{}", token);
        if (token.equals(value)) {
            Short identity = user.getIdentity();
            //身份判断
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
        return "参数不合法";

    }

    //用户注册
    @UnInterception
    @ApiOperation(value = "用户注册")
    @PostMapping("add/user")
    public String insertUser(@RequestBody AddUserRequest userRequest){
        User user = new User();
        BeanUtils.copyProperties(userRequest,user);
        user.setCreatetime(new Date());
        user.setLastlogintime(new Date());

        //在注册时就生成了一个token
        String token = tokenService.getToken(user);
        log.info("requestToken-{}", token);
        //判断用户名是否重复
        if(stringRedisTemplate.opsForValue().get("token").equals(token)){
            return "用户名重复，请更改用户名";
        }
        // 将token存入Redis中
        stringRedisTemplate.opsForValue().set("token",token);
         if (userService.insertUser(user).equals(1)){
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

    /**
     * 方法描述
     * @ 更改用户信息
     * @return
     * @date 2020/2/25
     */
    @ApiOperation(value = "更改用户信息")
    @PostMapping("updata/user")
    public SzpJsonResult<String> updateById(@RequestBody UpdataUserRequest userRequest, Long id) {
        boolean isSuccess = userService.updateUserById(userRequest, id);
        return SzpJsonResult.ok(isSuccess);
    }
}
