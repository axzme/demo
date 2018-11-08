package com.springboot.mapper;

import com.springboot.model.user.SysUser;
import com.springboot.util.WyBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysUserMapper extends WyBaseMapper<SysUser>{
    SysUser findByUsername(String username);
}
