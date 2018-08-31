package com.springboot.controller;

import com.springboot.model.Person;
import com.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("springboot/login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping(value = "token",method = RequestMethod.POST)
    public void login(String token){

    }
    @RequestMapping(value = "name",method = RequestMethod.POST)
    public List<Person> loginByName(Person person){
        return loginService.selectUser(person);
    }

    @RequestMapping(value = "temp",method = RequestMethod.GET)
    public List<Person> selectTemp(){
        return loginService.selectTemp();
    }
}
