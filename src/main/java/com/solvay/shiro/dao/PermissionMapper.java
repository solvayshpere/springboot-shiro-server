package com.solvay.shiro.dao;

import com.solvay.shiro.entity.Permission;
import com.solvay.shiro.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface PermissionMapper {
    Set<Permission> findPermissionsByRoleId(@Param("roles") Set<Role> roles);
}