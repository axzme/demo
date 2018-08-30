package com.springboot.controller;

import com.springboot.model.Person;
import com.springboot.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "springboot/person")
@Api(value = "/person")
public class PersonController {

   @Autowired  PersonService personService;
   @RequestMapping(value = "/query",method = RequestMethod.GET)
   @ApiOperation(value = "/query",response = Person.class)
    public List<Person> query(int id){
        return personService.query(id);
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public int insert(Person person){
        return personService.insert(person);
    }

    @RequestMapping(value = "select",method = RequestMethod.GET)
    public Object select(){
        return personService.select();
    }

}
