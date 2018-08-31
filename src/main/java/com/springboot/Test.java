package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @MapperScan注解识别mapper类，在类上使用@Mapper会被springboot识别
 *
 */
@SpringBootApplication
/*
@MapperScan(basePackages = "com.springboot.mapper")
*/
public class Test {
    public static void main(String[] args){
        SpringApplication.run(Test.class,args);
    }
}
