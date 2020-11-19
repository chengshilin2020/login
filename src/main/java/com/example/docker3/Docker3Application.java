package com.example.docker3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.example.docker3.mapper")
@EnableCaching
@SpringBootApplication
public class Docker3Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Docker3Application.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(Docker3Application.class);
    }
}
