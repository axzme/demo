package com.springboot.controller;

import com.springboot.annotation.AnnotationTest;
import com.springboot.model.Student;
import com.springboot.service.StudentService;
import com.springboot.util.mail.SendMailUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

@Api("student")
@RequestMapping("/springboot/student")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    //用于发送邮件
    private JavaMailSender jms;
    @RequestMapping(value = "test",method = RequestMethod.GET)
    @ApiOperation(value = "/test",response = Student.class)
    public void testStudent(){
        Class cls= null;  //获取类对象
        try {
            cls = Class.forName("com.springboot.model.Student");
            Field[] field=cls.getDeclaredFields();          //获取类的属性数组
            for(Field f:field){                             //循环属性
                if(f.isAnnotationPresent(AnnotationTest.class)){ //获取属性的注解，并判断是否是Car_color.class注解
                    AnnotationTest student = f.getAnnotation(AnnotationTest.class);     //获取Car_color注解对象
                    System.out.println("gender："+student.gender());            //输出注解的color配置参数
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("mail")
    public String sendMailTest(){
      return  studentService.sendMailMessage(jms);
    }
}
