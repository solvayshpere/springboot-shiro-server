package com.solvay.shiro.service;

import com.solvay.shiro.entity.User;

public interface UserService {

    void insert(User user);

    void del(String username);

    void saveUser(User user);

    /** 根据用户名 查询用户 */
    User findByUserName(String username);
    /** 修改用户信息 */
    int updateUser(User user);
}
