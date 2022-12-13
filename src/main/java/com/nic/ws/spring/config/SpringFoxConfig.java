package com.nic.ws.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.nic.ws.spring.dao.Bean;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@EnableWebMvc
public class SpringFoxConfig extends WebMvcConfigurerAdapter{
	@Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.nic.ws.spring.controller"))
            .build()
            .apiInfo(apiInfo());
    }
	
	 ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	            .title("CCI Web Service Documentation")
	            .description("Developed by Biswadeb Mukherjee")
	            .license("Java 1.7")
	            .licenseUrl("#")
	            .termsOfServiceUrl("")
	            .version("1.0.0")
	            .contact(new Contact("", "", "nicpoms@gmail.com"))
	            .build();
	    }

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("swagger-ui.html")
	      .addResourceLocations("classpath:/META-INF/resources/");

	    registry.addResourceHandler("/webjars/**")
	      .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
