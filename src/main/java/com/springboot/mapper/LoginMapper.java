package com.springboot.mapper;

import com.springboot.model.Person;
import com.springboot.util.WyBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface LoginMapper extends WyBaseMapper<Person> {
    /*@Select("select * from person")*/
    List<Person> selectTemp();
}
