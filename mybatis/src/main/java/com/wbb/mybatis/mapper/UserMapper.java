package com.wbb.mybatis.mapper;

import com.wbb.mybatis.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user")
    List<User> selectAll();

    @Select("select id,name,age,user_phone from user where id = #{id}")
    User selectById(Integer id);

    @Delete("delete from user where id = #{id}")
    int deleteById(@Param("id") Integer id);

    @Update("update user set name = #{u.name} where id = #{u.id}")
    int update(@Param("u")User user);

    @Insert("insert into user(name,age,user_phone) values(#{u.name},#{u.age},#{u.userPhone})")
    int add(@Param("u")User user);
}
