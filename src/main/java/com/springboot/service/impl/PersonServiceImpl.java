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
    public Person query(Integer id) {
        return personMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Person person) {
        return personMapper.insert(person);
    }

    @Override
    public Object select() {
        return personMapper.selectAll();
    }

    @Override
    public Object delete(Person person) {
        return personMapper.deleteByPrimaryKey(person);
    }

    @Override
    public Object update(Person person) {
        return personMapper.updateByPrimaryKeySelective(person);
    }

}
