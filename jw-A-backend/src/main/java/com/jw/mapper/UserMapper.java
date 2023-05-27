package com.jw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jw.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
