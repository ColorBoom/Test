package com.example.demo_jsqlparser.service.impl;

import com.example.demo_jsqlparser.entity.User;
import com.example.demo_jsqlparser.mapper.IUserMapper;
import com.example.demo_jsqlparser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public List<User> findBySql() {
        return userMapper.findBySql();
    }

    @Override
    public List<User> findAllBySql() {
        return userMapper.findAllBySql();
    }
}
