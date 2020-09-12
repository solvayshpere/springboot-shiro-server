package com.solvay.shiro.dao;

import com.solvay.shiro.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface RoleMapper {
    Set<Role> findRolesByUserId(@Param("uid") Integer uid);

    void addPermission(@Param("rid") Integer rid, @Param("pid") Integer pid);

    void delPermission(@Param("rid") Integer rid, @Param("pid") Integer pid);
}