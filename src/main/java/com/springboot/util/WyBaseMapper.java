package com.springboot.util;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @param <T>采用mapper的通用模板
 */
@Repository
public interface WyBaseMapper<T> extends tk.mybatis.mapper.common.Mapper<T>,MySqlMapper<T>{

}

