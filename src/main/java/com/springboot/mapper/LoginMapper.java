package com.springboot.mapper;

import com.springboot.model.Person;
import com.springboot.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LoginMapper extends BaseMapper<Person>{
    @Override
    List<Person> select(Person person);
}
