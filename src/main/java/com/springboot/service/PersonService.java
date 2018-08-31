package com.springboot.service;

import com.springboot.model.Person;

import java.util.List;

public interface PersonService {
    Person query(Integer id);

    int insert(Person person);

    Object select();

    Object delete(Person person);

    Object update(Person person);
}
