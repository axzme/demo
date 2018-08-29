package com.springboot.service;

import com.springboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
    List<Person> query(int id);
    int insert(Person person);

    boolean exists(Person person);

    Object select();
}
