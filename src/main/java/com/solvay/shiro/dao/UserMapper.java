package com.solvay.shiro.dao;

import com.solvay.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User findByUserName(String userName);
    int insert(User user);
    int del(@Param("username") String username);

    int update(User user);
}