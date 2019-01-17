package com.wbb.jpa.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Person {

    @Id //主键id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增
    private Integer id;
    private String name;
}
