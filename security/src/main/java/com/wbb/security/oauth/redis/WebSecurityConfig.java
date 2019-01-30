package com.wbb.security.oauth.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
/**
 * Spring Security默认是禁用注解的，要想开启注解， 需要在继承WebSecurityConfigurerAdapter,并在类上加@EnableGlobalMethodSecurity注解
 * 这里使用redis存储token
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private ClientDetailsService clientDetailsService;

    @Bean
    public TokenStore tokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Bean
    public MyUserDetailsService myUserDetailsService(){
        return new MyUserDetailsService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .and().logout().logoutUrl("/logout").deleteCookies("JSESSIONID").permitAll()
                .and().authorizeRequests()
//                .and()
//                .authorizeRequests()
                .antMatchers("/login.html").permitAll()
//                .antMatchers("/swagger-ui.html").permitAll()
//                .antMatchers("/webjars/**").permitAll()
//                .antMatchers("/swagger-resources/**").permitAll()
//                .antMatchers("/v2/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }

    /**
     * spring5.x 需要注入一个PasswordEncoder，否则会报这个错There is no PasswordEncoder mapped for the id \"null\"
     * 加了密码加密，所有用到的密码都需要这个加密方法加密
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 需要配置这个支持password模式
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    @Autowired
    public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore){
        TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
        handler.setTokenStore(tokenStore);
        handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
        handler.setClientDetailsService(clientDetailsService);
        return handler;
    }

    @Bean
    @Autowired
    public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
        TokenApprovalStore store = new TokenApprovalStore();
        store.setTokenStore(tokenStore);
        return store;
    }
}
