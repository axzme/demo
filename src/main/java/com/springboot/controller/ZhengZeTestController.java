package com.springboot.controller;

import com.springboot.model.ZhengZeTestBean;
import io.swagger.annotations.Api;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "springboot/zhengZe",produces = APPLICATION_JSON_UTF8_VALUE)
@Api("/zhengZe")
public class ZhengZeTestController {
    @RequestMapping()
    public void validateZhengZe(@Valid ZhengZeTestBean zhengZeTestBean, BindingResult result){
       /* String reg = "^[a-z0-9A-Z_\\u1000-\\u109F]{1,20}$";//表示+表示一个或多个中文*/
       /* System.out.println(str.matches(reg));*/
       if (result.hasErrors()){
           System.out.println(result.getFieldError().getDefaultMessage());
       }else {
           System.out.println("ok");
       }
    }
}
