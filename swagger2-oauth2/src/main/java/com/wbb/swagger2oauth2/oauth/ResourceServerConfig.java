//package com.wbb.swagger2oauth2.oauth;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
//@Configuration
//@EnableResourceServer
///**
// * 这里设置访问路径权限
// */
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")          //默认加上前缀ROLE_,目前原因未知
//                .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
//                .antMatchers("/test").authenticated()
//                .antMatchers("/swagger-ui.html").permitAll()
//                .antMatchers("/webjars/**").permitAll()
//                .antMatchers("/swagger-resources/**").permitAll()
//                .antMatchers("/v2/**").permitAll()
//                .anyRequest().authenticated();
//    }
//
//}
