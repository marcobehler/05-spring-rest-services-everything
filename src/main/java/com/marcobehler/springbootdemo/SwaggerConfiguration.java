package com.marcobehler.springbootdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.not;

/**
 * Thanks for watching this episode! Send any feedback to info@marcobehler.com!
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
               // .apis(RequestHandlerSelectors.basePackage("com.marcobehler.springbootdemo"))
               // .apis(not(RequestHandlerSelectors.withClassAnnotation(IgnoreMe.class)))
                .paths(PathSelectors.ant("/customers/**"))
                .build();
    }

}
