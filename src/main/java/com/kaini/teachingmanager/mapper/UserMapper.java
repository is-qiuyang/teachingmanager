package com.kaini.teachingmanager.mapper;

import com.kaini.teachingmanager.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends CommonMapper<User> {
}