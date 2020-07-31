package com.icom.invoice.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
public class Swagger2Config {
	
	@Bean
	public Docket orderApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("invoice")
		        .select() 
		        .apis(RequestHandlerSelectors.any()) 
		        .paths(PathSelectors.any())
		        .build()
		        .apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
	    return new ApiInfo(
	            "Invoice Service",
	            "Invoice Service",
	            "0.1",
	            "....",
	            new Contact("Khanh Luu","http://...","khanh.lpv@mail.com"),
	            "LICENSE",
	            "LICENSE URL",
	            Collections.emptyList()
	    );
	}
}
