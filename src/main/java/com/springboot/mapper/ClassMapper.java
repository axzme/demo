package com.springboot.mapper;

import com.springboot.model.Classs;
import com.springboot.util.WyBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface ClassMapper extends WyBaseMapper<Classs>{
}
