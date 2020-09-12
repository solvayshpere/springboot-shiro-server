package com.solvay.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: solvay
 * @date: 2018/5/11
 * @description: 客户端信息
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Client implements Serializable {

    private String id;
    private String clientName;
    private String clientId;
    private String clientSecret;
}