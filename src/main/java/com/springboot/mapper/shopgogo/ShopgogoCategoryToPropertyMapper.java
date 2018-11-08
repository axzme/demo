package com.springboot.mapper.shopgogo;

import com.springboot.model.shopgogo.ShopgogoCategoryToProperty;
import com.springboot.util.WyBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShopgogoCategoryToPropertyMapper extends WyBaseMapper<ShopgogoCategoryToProperty> {
}