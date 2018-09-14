package com.springboot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        Page<Person> page = new Page();
        page.setPageNum(1);
        page.setPageSize(1);
        page.setOrderBy("create_time desc");
        PageHelper.startPage(page.getPageNum(),page.getPageSize(),page.getOrderBy());
        List<Person> personList = personMapper.selectAll();
        PageInfo<Person> pageInfo = new PageInfo(personList);
        return pageInfo;
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
