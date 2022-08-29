package com.project.babynaming.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private  static final  String URL="http://fakeapi.com";

    private ApiKey apiKey()
    {
        return new ApiKey("JWT","Authorization","header");
    }
    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
    @Bean
    public Docket projectApi()
    {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/")
                .securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apiKey()))
                .groupName("Baby Naming Group").select().apis(RequestHandlerSelectors
                        .basePackage("com.project.babynaming.controller")).paths(PathSelectors.any()).build();

    }
    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder().title("Project Api")
                .description("Baby Naming project Api")
                .termsOfServiceUrl(URL)
                .contact(new Contact("Project API",URL,"fake@gmail.com"))
                .license("Project License").licenseUrl(URL).build();
    }
}
