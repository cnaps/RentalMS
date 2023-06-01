package com.inflearn.rentalcard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
               // .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.inflearn.rentalcard"))
                .paths(PathSelectors.any())
                .build();
    }
}