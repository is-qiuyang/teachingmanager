package com.kaini.teachingmanager.interceptor;

import com.kaini.teachingmanager.annotation.UnInterception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
@Component
public class ControllerInterceptor implements HandlerInterceptor {
    /**
     * 在所有http请求进来之前
     * 所有方法落到这个上面去校验
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) factory.getBean("stringRedisTemplate");
        log.info("进入拦截器-{}",request.getHeader("token"));

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();
        log.info("====拦截到了方法：{}，在该方法执行之前执行====", methodName);

        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(UnInterception.class)) {
            log.info("有进行这步");
            UnInterception passToken = method.getAnnotation(UnInterception.class);
            if (passToken.required()) {
                return true;
            }
        }

        //
        String token = request.getHeader("token");
        String value = stringRedisTemplate.opsForValue().get("token");
        if (StringUtils.isEmpty(value)){
            return false;
        }
        log.info("token-{}",token);
        return true;
    }

//    @Override
//      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        Method method = handlerMethod.getMethod();
//        String methodName = method.getName();
//        log.info("====拦截到了方法：{}，在该方法执行之前执行====", methodName);
//
//        //检查是否有passtoken注释，有则跳过认证
//        if (method.isAnnotationPresent(UnInterception.class)) {
//            UnInterception passToken = method.getAnnotation(UnInterception.class);
//            if (passToken.required()) {
//                return true;
//            }
//        }
//
//        // 判断用户有没有登陆，一般登陆之后的用户都有一个对应的token
//        String token = request.getHeader("token");
//        log.info("token:",token);
//        //String token = request.getParameter("token");
//        if (null == token || "".equals(token)) {
//            log.info("用户未登录，没有权限执行……请登录");
//            return false;
//        }
//        // 返回true才会继续执行，返回false则取消当前请求
//        return true;
//    }

}
