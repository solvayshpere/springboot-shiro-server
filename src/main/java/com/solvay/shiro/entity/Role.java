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
public class Role implements Serializable {
    private Integer id;
    private String role;
    private String description;
    private String available;
    private Set<User> users = new HashSet<>();
    private Set<Permission> permissions = new HashSet<>();
}