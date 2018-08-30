package com.springboot.controller;

import com.springboot.model.Person;
import com.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("springboot/login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping("token")
    public void login(String token){

    }

    @RequestMapping("name")
    public List<Person> loginByName(Person person){
        return loginService.selectUser(person);
    }
}
