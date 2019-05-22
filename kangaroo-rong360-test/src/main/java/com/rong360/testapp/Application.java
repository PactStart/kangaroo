package com.rong360.testapp;

import io.github.pactstart.rong360.autoconfigure.EnableRong360Api;
import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.auth.AuthenticationService;
import io.github.pactstart.simple.web.framework.externs.DefaultRequestCompleteCallbackServiceImpl;
import io.github.pactstart.simple.web.framework.externs.RequestCompleteCallbackService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@EnableRong360Api
@RestController
@ComponentScan(basePackages = {"io.github.pactstart", "com.rong360.testapp"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public AuthenticationService authenticationService() {
        return new AuthenticationService() {

            @Override
            public AuthenticationInfo auth(HttpServletRequest request) {
                return null;
            }
        };
    }

    @Bean
    public RequestCompleteCallbackService requestCompleteCallbackService() {
        return new DefaultRequestCompleteCallbackServiceImpl();
    }

    @ResponseBody
    @GetMapping("/")
    public Object index() {
        return "hello,world";
    }

}
