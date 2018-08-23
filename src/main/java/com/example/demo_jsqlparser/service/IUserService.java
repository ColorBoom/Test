package com.example.demo_jsqlparser.service;

import com.example.demo_jsqlparser.entity.User;

import java.util.List;

public interface IUserService {

    List<User> findBySql();

    List<User> findAllBySql();
}
