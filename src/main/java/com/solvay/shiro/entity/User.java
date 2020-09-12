package com.solvay.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String name;
    private String id_card_num;
    private String state;
    private Set<Role> roles = new HashSet<>();
}