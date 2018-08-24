package com.example.demo_jsqlparser.mapper;

import com.example.demo_jsqlparser.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserMapper {

    @Select("select name,sex,(select '1433608734@qq.com' from dual where 1=1) email from User where 1=1 and sex between 0 and 2 ")
    List<User> findBySql();

    List<User> findAllBySql();
}
