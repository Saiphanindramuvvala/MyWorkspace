//package com.authentication.config;
//
//import com.google.common.base.Predicates;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.Arrays;
//
//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public Docket config() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
//                .select().apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .paths(Predicates.not(PathSelectors.regex("/error.*")))
//                .paths(Predicates.not(PathSelectors.regex("/actuator.*")))
//                .build();
//    }
//
//    public static final Contact DEFAULT_CONTACT = new Contact(
//            "Sports facility", "", "");
//
//    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
//            "Register & Login Service", "This service is responsible for registering a new player and login a player.", "1.0",
//            "urn:tos", DEFAULT_CONTACT,
//            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Arrays.asList());
//
//}