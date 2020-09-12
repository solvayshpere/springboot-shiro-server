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
public class Permission implements Serializable {
    private Integer id;
    private Integer parent_id;
    private String parent_ids;
    private String permission;
    private String resource_type;
    private String url;
    private String name;
    private String available;
    private Set<Role> roles = new HashSet<>();
}