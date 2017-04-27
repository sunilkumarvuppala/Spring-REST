/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunil.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig{

    public SwaggerConfig() {
    }
//    
//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .pathMapping("/api/*")
 //               .useDefaultResponseMessages(false)
//                .apiInfo(apiInfo());
//    }
//    
//    private ApiInfo apiInfo(){
//        Contact contact = new Contact("admin", "https://linkedin.com/in/sunilkumarvuppala", "svuppal2@uncc.edu");
//        ApiInfo info = new ApiInfo("Spring-REST API", "A simple REST Api", "1.0.0", "TnC", contact, "MIT", "https://opensource.org/licences/MIT");
//        return info;
//    }
}