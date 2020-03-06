package com.kaini.teachingmanager.utils;

import com.auth0.jwt.JWT;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class TokenUtil {
    /**
     * 方法描述
     * @ 验证token
     * @return
     * @date 2020/3/5
     */
    public static String checkToken() {
        String token = getRequest().getHeader("token");// 从 http 请求头中取出 token
        String s = JWT.decode(token).getAudience().get(0);
        return s;
    }
    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
}
