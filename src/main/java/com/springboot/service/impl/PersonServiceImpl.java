package com.springboot.service.impl;

import com.springboot.mapper.PersonMapper;
import com.springboot.model.Person;
import com.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
   @Autowired private PersonMapper personMapper;
    @Override
    public List<Person> query(int id) {
        return personMapper.query(id);
    }

    @Override
    public int insert(Person person) {
        return personMapper.insert(person);
    }

    @Override
    public boolean exists(Person person) {
        return personMapper.exists(person.getId());
    }

    @Override
    public Object select() {
        return personMapper.select();
    }

}
