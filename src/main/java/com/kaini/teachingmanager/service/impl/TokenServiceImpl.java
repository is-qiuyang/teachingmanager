package com.kaini.teachingmanager.service.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class TokenServiceImpl {

    public static final String SUBJECT = "likaini";

    public static final long EXPIRE = 1000*60*60*24*7;  //过期时间，毫秒，一周

    //秘钥
    public static final  String APPSECRET = "likaini666";

    /**
     * 方法描述
     * @ 生成token
     * @return String
     * @date 2020/3/5
     */
    public String getToken(String name) {

        if(name.isEmpty()){
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("name",name)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();
        return token;
    }

}
