package com.kaini.teachingmanager.service.impl;


import com.kaini.teachingmanager.dao.UserDao;
import com.kaini.teachingmanager.pojo.User;
import com.kaini.teachingmanager.request.AddUserRequest;
import com.kaini.teachingmanager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
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
    public Integer insertUser(AddUserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setLoginname(userRequest.getLoginname());
        user.setPwd(userRequest.getPwd());
        user.setImg(userRequest.getImg());
        user.setEmail(userRequest.getEmail());
        user.setEnrollmenttime(userRequest.getEnrollmenttime());
        user.setMobile(userRequest.getMobile());
        user.setCreatetime(new Date());
        user.setLastlogintime(new Date());
        user.setIdentity(userRequest.getIdentity());
        user.setSex(userRequest.getSex());
        return userDao.insertUser(user);
    }

    /**
     * 方法描述
     * @ 更新用户最后登陆时间
     * @return
     * @date 2020/2/12
     */
    @Override
    public int updateLastLoginTime(User user) {
        return userDao.updateLastLoginTime(user);
    }

    /**
     * 方法描述
     * @ 删除用户
     * @return
     * @date 2020/2/12
     */
    @Override
    public Integer DeleteUserByName(String name) {
        if(StringUtils.isEmpty(name)){
            return -1;
        }else {
            return userDao.DeleteUserByName(name);
        }
    }

   //每年九月一日更新 @Scheduled(cron = "0 0 0 1 9 ? *")
   @Scheduled(cron = "0/59 * * * * *")
    public int updataClockById() {
        List<User> users = userDao.selectAllUser();
        List<Long> enrollmenttimeList = new ArrayList<>();
        for(User user : users){
            String enrollmenttime = user.getEnrollmenttime();
            long clock = insertTiemer(enrollmenttime);
            log.info("还有："+clock+"年");
            if (clock<0 && clock>4){
                Long id = user.getId();
                enrollmenttimeList.add(id);
            }
        }
        log.info("testListSize:"+enrollmenttimeList.size()+"删除成功："+userDao.deleteAllUser(enrollmenttimeList));
        return userDao.deleteAllUser(enrollmenttimeList);
    }

    /**
     * 方法描述
     * @ 倒计时还有多少年，输入的是入学年份
     * @return long
     * @date 2020/2/8
     */
    public long insertTiemer(String enrollmenttime){
        //获取当前系统时间
        LocalDateTime endTime =LocalDateTime.now();
        //将输入的时间转化为localDateTime
        //String转化为LocalDataTime
        LocalDateTime nowTime = LocalDateTime.parse(enrollmenttime, DateTimeFormatter.ofPattern("yyyy"));
        //时间差
        Period period = Period.between(nowTime.toLocalDate(),endTime.toLocalDate());
        //相差的年数
        long periodYears = period.getYears();
        //相差分钟数，用于测试
        //long durationminutes = duration.toMinutes();

        return periodYears;
    }

}
