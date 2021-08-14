package com.example.mongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Swagger Configuration
 *
 * @author Bharat Bhardwaj <bharat.bhardwaj@moglix.com>
 */

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
@Bean
public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2).select()
			.apis(RequestHandlerSelectors.basePackage("com.example.mongo.controller"))
			.build()
			.apiInfo(this.apiInfo());
}

private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Swagger 2 and MongoDB").description("Swagger 2 and MongoDB practice.").version("1.0.0").
    		contact(new Contact("Bharat Bhardwaj", "", "bhrtbhrdwaj@gmail.com")).build();
}
}
