package com.springboot.mapper;

import com.springboot.model.Student;
import com.springboot.util.WyBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StudentMapper extends WyBaseMapper<Student> {
}