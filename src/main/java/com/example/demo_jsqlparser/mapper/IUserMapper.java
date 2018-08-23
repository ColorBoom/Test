package com.example.demo_jsqlparser.mapper;

import com.example.demo_jsqlparser.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserMapper {

    @Select("select * from User")
    List<User> findBySql();

    List<User> findAllBySql();
}
