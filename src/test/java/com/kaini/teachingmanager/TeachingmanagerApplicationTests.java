package com.kaini.teachingmanager;

import com.kaini.teachingmanager.pojo.User;
import com.kaini.teachingmanager.service.impl.TokenServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeachingmanagerApplicationTests {
    @Autowired
    private TokenServiceImpl tokenService;

    @Test
    void contextLoads() {
    }

    @Test
    public void token(){
        User user =new User();
        user.setName("asd");
        user.setPwd("qwdqs");
        String token = tokenService.getToken(user.getName());
        System.out.println(token);
    }

}
