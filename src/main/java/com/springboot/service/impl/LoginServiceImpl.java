package com.springboot.service.impl;

import com.springboot.mapper.LoginMapper;
import com.springboot.model.Person;
import com.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;
    @Override
    public List<Person> selectUser(Person person) {
       /* return loginMapper.selectAll();*/
        return loginMapper.select(person);
    }

    @Override
    public List<Person> selectTemp() {
        return loginMapper.selectTemp();
    }
}
