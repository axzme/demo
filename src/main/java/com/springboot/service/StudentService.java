package com.springboot.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    String sendMailMessage(JavaMailSender jms) ;
}
