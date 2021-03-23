package com.chy.config;


import com.chy.handler.DemoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chy
 * @since 2021-03-21 21:08
 */
//@Configuration
//public class InterceptorConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new DemoInterceptor())
//                .addPathPatterns("/**").excludePathPatterns("/login");
//    }
//}
