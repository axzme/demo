package com.springboot.controller;
import com.springboot.model.Classs;
import com.springboot.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("classs")
public class ClassController {
    @Autowired
    ClassService classService;
    @RequestMapping("select")
   public List<Classs> select(Classs classs){
       return classService.select(classs);
   }
}
