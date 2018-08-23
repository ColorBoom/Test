package com.example.demo_jsqlparser;

import com.example.demo_jsqlparser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/qu")
    public String querUser(){
        return userService.findBySql().toString();
    }

    @RequestMapping("/all")
    public String querAllUser(){
        return userService.findAllBySql().toString();
    }
}
