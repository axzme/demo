package com.springboot.mapper;

import com.springboot.model.Classs;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ClassMapper {

    List<Classs> select();
}
