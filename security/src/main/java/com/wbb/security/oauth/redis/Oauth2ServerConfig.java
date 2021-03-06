//package com.wbb.security.oauth.redis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
///**
// * 使用@EnableAuthorizationServer 注解来配置OAuth2.0 授权服务机制，通过使用@Bean注解的几个方法一起来配置这个授权服务
// * 这几个配置是由Spring创建的独立的配置对象，它们会被Spring传入AuthorizationServerConfigurer中：
//        ClientDetailsServiceConfigurer：用来配置客户端详情服务（ClientDetailsService），客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息。
//        AuthorizationServerSecurityConfigurer：用来配置令牌端点(Token Endpoint)的安全约束.
//        AuthorizationServerEndpointsConfigurer：用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
// *以上的配置可以选择继承AuthorizationServerConfigurerAdapter并且覆写其中的三个configure方法来进行配置。
// */
//@Configuration
//@EnableAuthorizationServer
//public class Oauth2ServerConfig extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    TokenStore tokenStore;
//    @Autowired
//    private UserApprovalHandler userApprovalHandler;
//
//
//    @Value("${spring.security.oauth2.client.clientId}")
//    private String clientId;
//    @Value("${spring.security.oauth2.client.clientSecret}")
//    private String clientSecret;
//    @Value("${spring.security.oauth2.client.redirectUris}")
//    private String[] redirectUris;
//    @Value("${spring.security.oauth2.client.authorizedGrantTypes}")
//    private String[] authorizedGrantTypes;
//    @Value("${spring.security.oauth2.client.resourceIds}")
//    private String resourceIds;
//    @Value("${spring.security.oauth2.client.scopes}")
//    private String[] scopes;
//    @Value("${spring.security.oauth2.client.accessTokenValiditySeconds}")
//    private int accessTokenValiditySeconds;
//    @Value("${spring.security.oauth2.client.refreshTokenValiditySeconds}")
//    private int refreshTokenValiditySeconds;
//    /**
//     * 用来配置客户端详情服务（ClientDetailsService），客户端详情信息在这里进行初始化，能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息。
//     * clientId：（必须的）用来标识客户的Id。
//     * secret：（需要值得信任的客户端）客户端安全码，如果有的话。
//     * redirectUris 返回地址,可以理解成登录后的返回地址，可以多个。应用场景有:客户端swagger调用服务端的登录页面,登录成功，返回客户端swagger页面
//     * authorizedGrantTypes：此客户端可以使用的权限（基于Spring Security authorities）
//         authorization_code：授权码类型、implicit：隐式授权类型、password：资源所有者（即用户）密码类型、
//         client_credentials：客户端凭据（客户端ID以及Key）类型、refresh_token：通过以上授权获得的刷新令牌来获取新的令牌。
//     * scope：用来限制客户端的访问范围，如果为空（默认）的话，那么客户端拥有全部的访问范围。
//     * accessTokenValiditySeconds token有效时长
//     * refreshTokenValiditySeconds refresh_token有效时长
//     * @param clients
//     * @throws Exception
//     */
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient(clientId)
//                .secret(new BCryptPasswordEncoder().encode(clientSecret))
//                .redirectUris(redirectUris)
//                .authorizedGrantTypes(authorizedGrantTypes)
//                .scopes(scopes)
//                .resourceIds(resourceIds)
//                .accessTokenValiditySeconds(accessTokenValiditySeconds)
//                .refreshTokenValiditySeconds(refreshTokenValiditySeconds);
//    }
//
//    /**
//     * 用来配置令牌端点(Token Endpoint)的安全约束.
//     * @param security
//     * @throws Exception
//     */
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//       security.realm(resourceIds)
//               .tokenKeyAccess("permitAll()")
//               .checkTokenAccess("isAuthenticated()")
//               .allowFormAuthenticationForClients();
//    }
//
//    /**
//     * 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
//     * 访问地址：/oauth/token
//     * 属性列表:
//     * authenticationManager：认证管理器，当你选择了资源所有者密码（password）授权类型的时候，请设置这个属性注入一个 AuthenticationManager 对象。\
//     *
//     * @param endpoints
//     * @throws Exception
//     */
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
//                .authenticationManager(authenticationManager);
//        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST);//获取token允许的访问方式
//    }
//}
