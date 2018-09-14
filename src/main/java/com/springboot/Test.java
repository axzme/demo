package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;
import java.util.Timer;


/**
 * @MapperScan注解识别mapper类，在类上使用@Mapper会被springboot识别
 *
 */
@SpringBootApplication
@EnableScheduling
/*
@MapperScan(basePackages = "com.springboot.mapper")
*/
public class Test {
    public static void main(String[] args){
        SpringApplication.run(Test.class,args);
    }
    /*@Bean
    public   taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        //线程池大小
        scheduler.setPoolSize(10);
        //线程名字前缀
        scheduler.setThreadNamePrefix("springboot-task-thread");
        return scheduler;
    }*/
}
