package com.chenddd.timeemail.config;

/**
 * Author: chenddd
 * Date: 2022/11/18 11:45
 * FileName: IntercaptorConfig
 * Description:
 */

import com.chenddd.timeemail.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: JWT拦截器
 * @Date: 2022/4/5 17:30
 * @Author: Yang Yezhuang
 */
@Configuration
public class IntercaptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                //拦截的路径
                .addPathPatterns("/emailAdmin/**")
                //排除接口
                .excludePathPatterns("/emailAdmin/login");
    }
}


