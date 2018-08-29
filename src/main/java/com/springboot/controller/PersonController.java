package com.springboot.controller;

import com.springboot.model.Person;
import com.springboot.service.ClassService;
import com.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "person")
public class PersonController {

   @Autowired  PersonService personService;
   @RequestMapping("/query")
    public List<Person> query(int id){
        return personService.query(id);
    }

    @RequestMapping("insert")
    public int insert(Person person){
        return personService.insert(person);
    }

    @RequestMapping("exists")
    public boolean exists(Person person){
        return personService.exists(person);
    }

    @RequestMapping("select")
    public Object select(){
        return personService.select();
    }

}
