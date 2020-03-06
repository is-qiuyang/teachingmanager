package com.kaini.teachingmanager.service.impl;

import com.kaini.teachingmanager.pojo.User;
import io.jsonwebtoken.Claims;
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
    public String getToken(User user) {

        if(user == null || user.getName() == null
                || user.getPwd()==null || user.getIdentity()==null){
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("name",user.getName())
                .claim("pwd",user.getPwd())
                .claim("identity",user.getIdentity())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();

        return token;
    }
    /*
     * 获取 Token 中注册信息
     */
    public Claims getTokenClaim (String token) {
        try {
            return Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

//        Date start = new Date();
//        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
//        Date end = new Date(currentTime);
//        String token;
//        token = JWT.create().withAudience(user.getName()).withIssuedAt(start).withExpiresAt(end)
//                .sign(Algorithm.HMAC256(user.getPwd()));
//        log.info("token:",token);
//        return token;
 //   }

}
