package com.kaini.teachingmanager.config;

import com.kaini.teachingmanager.interceptor.ControllerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class MvcInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 实现WebMvcConfigurer不会导致静态资源被拦截
        //将swagger的访问路径放行
        registry.addInterceptor(new ControllerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }
}
//public class MvcInterceptorConfig extends WebMvcConfigurerAdapter {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 多个拦截器组成一个拦截器链
//        // addPathPatternstterns 用于添加拦截规则，/**表示拦截所有请求
//        // excludePathPatterns 用户排除拦截
//        log.info("拦截器启动");
//        registry.addInterceptor(new ControllerInterceptor())
//                .addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }
//
//    /**
//     * 用来指定静态资源不被拦截，否则继承WebMvcConfigurationSupport这种方式会导致静态资源无法直接访问
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        super.addResourceHandlers(registry);
//    }
//}
