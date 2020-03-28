package com.puyin.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.puyin.cn.dao")
@ServletComponentScan
@EnableCaching
public class EnterprisesPssApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnterprisesPssApplication.class, args);
    }

}
