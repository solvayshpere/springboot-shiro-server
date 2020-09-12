package com.solvay.shiro;

import com.solvay.shiro.entity.User;
import com.solvay.shiro.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootShiroThymleafApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setName("hahaha");
        user.setId_card_num("178888888888888888");
        user.setUsername("hahaha");
        userService.saveUser(user);
    }

}
