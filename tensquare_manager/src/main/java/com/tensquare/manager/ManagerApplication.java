package com.tensquare.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import util.IdWorker;


@EnableZuulProxy
@SpringBootApplication
public class ManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
