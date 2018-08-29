package com.springboot.service;

import com.springboot.model.Classs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {

    public List<Classs> select(Classs classs);
}
