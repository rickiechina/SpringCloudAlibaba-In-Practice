package com.rickie.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {
    @Value("${user.name:tom}")
    private String userName;

    @Value("${user.age:25}")
    private Integer age;

    @Autowired
    Environment environment;

    @RequestMapping("/user")
    public String simple() {
        return "Hello " + userName + ", " + age + "!";
    }

    @RequestMapping("/env")
    public String env() {
        String env_user = this.environment.getProperty("user.name");
        Integer env_age = Integer.valueOf(this.environment.getProperty("user.age"));

        return "Hello " + env_user + ", " + env_age + "!";
    }
}
