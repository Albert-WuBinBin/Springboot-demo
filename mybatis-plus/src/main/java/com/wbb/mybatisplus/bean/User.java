package com.wbb.mybatisplus.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class User implements Serializable{

    private Integer id;
    private String name;
    private Integer age;
    private String userPhone;
}
