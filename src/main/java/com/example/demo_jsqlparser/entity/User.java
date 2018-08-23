package com.example.demo_jsqlparser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;

    private String email;

    private Date testDate;

    private Long role;

    private Integer sex;
}
