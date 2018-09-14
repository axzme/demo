package com.springboot.service.impl;

import com.springboot.enumbean.MailEnum;
import com.springboot.model.Mail;
import com.springboot.service.StudentService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public String sendMailMessage(JavaMailSender jms) {
        //用于封装邮件信息的实例
        SimpleMailMessage smm=new SimpleMailMessage();
        Mail mail = new Mail();
        mail.setFrom(MailEnum.FROM.name());
        mail.setTo("2351424743@qq.com");
        mail.setFrom("");
        //由谁来发送邮件
        smm.setFrom(MailEnum.FROM.name());
        //邮件主题
        smm.setSubject("Hello");
        //邮件内容
        smm.setText("Hello SpringBoot_Email");
        //接受邮件
        smm.setTo("2351424743@qq.com");
        try {
            jms.send(smm);
            return "发送成功";
        } catch (Exception e) {
            return "发送失败///"+e.getMessage();
        }
    }
}
