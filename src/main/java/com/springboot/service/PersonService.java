package com.springboot.service;

import com.springboot.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> query(int id);
    int insert(Person person);

    boolean exists(Person person);

    Object select();
}
