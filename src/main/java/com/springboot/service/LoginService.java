package com.springboot.service;

import com.springboot.model.Person;

import java.util.List;

public interface LoginService {
    List<Person> selectUser(Person person) ;
}
