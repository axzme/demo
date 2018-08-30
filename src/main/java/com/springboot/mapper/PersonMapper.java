package com.springboot.mapper;

import com.springboot.model.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface PersonMapper extends CrudRepository<Person,Integer>{
    @Select("SELECT * FROM person WHERE id=#{id}")
     List<Person> query(int id);

    @Insert("INSERT INTO person (`id`,`name`,`password`,`address`)VALUES " +
            "(#{id},#{name },#{password },#{address})")
     int insert(Person person);


    Object select();
}
