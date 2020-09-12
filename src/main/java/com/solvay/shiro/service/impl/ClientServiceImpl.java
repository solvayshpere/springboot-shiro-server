package com.solvay.shiro.service.impl;

import com.solvay.shiro.dao.ClientMapper;
import com.solvay.shiro.entity.Client;
import com.solvay.shiro.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public Client findByClientId(String clientId) {
        return clientMapper.findByClientId(clientId);
    }

    @Override
    public Client findByClientSecret(String clientSecret) {
        return clientMapper.findByClientSecret(clientSecret);
    }
}
