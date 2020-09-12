package com.solvay.shiro.service.impl;


import com.solvay.shiro.dao.UserMapper;
import com.solvay.shiro.entity.User;
import com.solvay.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void del(String username) {
        userMapper.del(username);
    }

    @Override
    @Transactional
    public void saveUser(User user){
        userMapper.insert(user);

        int i = 1/0;
    }

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.update(user);
    }
}
