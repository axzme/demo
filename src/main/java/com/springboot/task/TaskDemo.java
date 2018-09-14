package com.springboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;

@Component
public class TaskDemo {
    /**
     * 秒 分 时 日 月 星期 年
     */
  //  @Scheduled(cron = "*/5 * * * * ?")
   /* public void printTask() {
        String time = DateFormat.getDateTimeInstance().format(new Date());
        System.out.println(Thread.currentThread().getName()+"定时器1触发打印" + time);
    }*/
   // @Scheduled(cron = "*/3 * * * * ?")
   /* public void sendMail() {
        String time = DateFormat.getDateTimeInstance().format(new Date());
        System.out.println(Thread.currentThread().getName()+"定时器2触发打印" + time);
    }*/
}
