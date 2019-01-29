package com.wbb.security.mapper;

import com.wbb.security.bean.RoleDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    @Select("select id,name,describe from role where id = #{id}")
    RoleDO selectById(@Param("id") Integer id);

}
