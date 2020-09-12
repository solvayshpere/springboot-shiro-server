package com.solvay.shiro.service;

import com.solvay.shiro.entity.Client;

public interface ClientService {
    /** 根据clientId查询Client信息 */
    public Client findByClientId(String clientId);
    /** 根据clientSecret查询client信息 */
    public Client findByClientSecret(String clientSecret);
}