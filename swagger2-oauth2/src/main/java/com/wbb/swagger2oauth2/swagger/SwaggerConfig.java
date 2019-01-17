package com.wbb.swagger2oauth2.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Component
@EnableSwagger2
public class SwaggerConfig {

    private static final AuthorizationScope authorizationScopeRead = new AuthorizationScope("read", "read");
    private static final AuthorizationScope authorizationScopeWrite = new AuthorizationScope("write", "write");
    public static final String securitySchemaOAuth2 = "oauth2schema";
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("swagger标题").version("1.0").description("write by wbb").build();
    }

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wbb.swagger2oauth2.controller"))
                .paths(PathSelectors.any())
                .build();

    }

    private List<AuthorizationScope> scopes(){
        List<AuthorizationScope> list = new ArrayList<>();
        list.add(authorizationScopeRead);
        list.add(authorizationScopeWrite);
        return list;
    }
}
