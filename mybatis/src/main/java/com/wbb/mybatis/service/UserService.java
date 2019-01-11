package com.wbb.mybatis.service;


import com.wbb.mybatis.bean.User;

import java.util.List;

public interface UserService {

    List<User> selectAll();

    User selectById(Integer id);

    int deleteById(Integer id);

    int add(User user);

    int update(User user);

}
