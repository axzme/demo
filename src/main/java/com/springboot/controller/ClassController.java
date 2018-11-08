package com.springboot.controller;
import com.springboot.model.Classs;
import com.springboot.service.ClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("springboot/classs")
@Api("/classs")
public class ClassController{
    @Autowired
    ClassService classService;
    @RequestMapping(value = "select",method = RequestMethod.GET)
    @ApiOperation(value = "/select",response = Classs.class)
   public List<Classs> select(){
       return classService.select();
   }
   @RequestMapping(value = "test",method = RequestMethod.POST)
    public String test(@DateTimeFormat(pattern = "HH:mm") Date date){
        System.out.println(date);
        return "ok";
    }

}
