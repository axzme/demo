package com.springboot.util;

import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.provider.base.BaseDeleteProvider;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;
import tk.mybatis.mapper.provider.base.BaseUpdateProvider;


/**
 * 采用mapper的通用模板
 * @param <T>
 */
public interface BaseMapper<T> {

    @InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
    int insert(T record);

    @InsertProvider(type = BaseInsertProvider.class,method = "dynamicSQL")
    int insertSelective(T record);

    @UpdateProvider(type = BaseUpdateProvider.class,method = "dynamicSQL")
    int updateByPrimaryKey(Object obj);

    @UpdateProvider(type = BaseUpdateProvider.class,method = "dynamicSQL")
    int updateByPrimaryKeySelective(T record);

    @DeleteProvider(type = BaseDeleteProvider.class,method = "dynamicSQL")
    int delete(T record);

    @DeleteProvider(type = BaseDeleteProvider.class,method = "dynamicSQL")
    int deleteByPrimaryKey(Object obj);

    @SelectProvider(type = BaseSelectProvider.class,method = "dynamicSQL")
    T selectOne(T record);

    @SelectProvider(type = BaseSelectProvider.class,method = "dynamicSQL")
    Object select(T record);

    @SelectProvider(type = BaseSelectProvider.class,method = "dynamicSQL")
    Object selectByRowBounds(T record);

    @SelectProvider(type = BaseSelectProvider.class,method = "dynamicSQL")
    T selectByPrimaryKey(Object obj);

    @SelectProvider(type = BaseSelectProvider.class,method = "dynamicSQL")
    Object selectCount(T record);

    @SelectProvider(type = BaseSelectProvider.class,method = "dynamicSQL")
    Object existsWithPrimaryKey(Object obj);

    @SelectProvider(type = BaseSelectProvider.class,method = "dynamicSQL")
    Object selectAll(T record);
}

