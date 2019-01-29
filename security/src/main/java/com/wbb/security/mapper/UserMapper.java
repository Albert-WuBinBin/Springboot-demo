package com.wbb.security.mapper;

import com.wbb.security.bean.UserDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select("select id,username,password from user where username = #{username}")
    UserDO selectByName(@Param("username") String username);
}
