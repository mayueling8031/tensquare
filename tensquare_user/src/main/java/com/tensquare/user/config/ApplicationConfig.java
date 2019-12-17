package com.tensquare.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration registration = registry.addInterceptor(jwtFilter());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns("/","/login","/error","/static/**","/logout");
    }


    @Bean
    public JwtFilter jwtFilter(){
        return new JwtFilter();
    }
}
