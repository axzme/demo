package com.springboot.service.impl;

import com.springboot.mapper.ClassMapper;
import com.springboot.model.Classs;
import com.springboot.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService{

    @Autowired
    ClassMapper classMapper;

    @Override
    public List<Classs> select() {
        return classMapper.selectAll();
    }
}
