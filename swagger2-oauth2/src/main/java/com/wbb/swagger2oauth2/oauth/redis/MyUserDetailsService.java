package com.wbb.swagger2oauth2.oauth.redis;

import com.wbb.swagger2oauth2.bean.UserDO;
import com.wbb.swagger2oauth2.bean.UserPermissionDO;
import com.wbb.swagger2oauth2.mapper.RoleMapper;
import com.wbb.swagger2oauth2.mapper.UserMapper;
import com.wbb.swagger2oauth2.mapper.UserPermissionMapper;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserPermissionMapper userPermissionMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("login name:"+username);
        UserDO userDO =userMapper.selectByName(username);
        if(userDO == null){
            throw  new UsernameNotFoundException("用户不存在");
        }
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        List<UserPermissionDO> userPermissionDOs = userPermissionMapper.selectByUserId(userDO.getId());
        for(UserPermissionDO userPermissionDO:userPermissionDOs){
            //这个权限牵涉到底层的投票机制，RoleVoter  默认角色名以 "ROLE_" 为前缀
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userPermissionDO.getRoleName()));
        }
        return new User(username,passwordEncoder.encode(userDO.getPassword()),authorities);
    }
}
