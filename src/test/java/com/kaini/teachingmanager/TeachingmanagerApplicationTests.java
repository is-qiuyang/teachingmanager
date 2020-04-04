package com.kaini.teachingmanager;

import com.kaini.teachingmanager.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeachingmanagerApplicationTests {


    @Test
    void contextLoads() {
    }

    @Test
    public void token(){
        User user =new User();
        user.setName("asd");
    }

}
