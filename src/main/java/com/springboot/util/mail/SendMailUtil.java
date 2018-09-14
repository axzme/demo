package com.springboot.util.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * 发送邮件工具
 */
public class SendMailUtil {
    @Autowired
    private JavaMailSender javaMailSender ;
    public  String sendMail(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("axz2222@163.com");
        simpleMailMessage.setTo("axz2222@163.com");
        simpleMailMessage.setText("hello world");
        simpleMailMessage.setSubject("hi");
        javaMailSender.send(simpleMailMessage);
        return "success";
    }

}
