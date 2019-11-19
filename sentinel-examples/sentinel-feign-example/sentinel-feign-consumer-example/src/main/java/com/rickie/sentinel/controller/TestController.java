package com.rickie.sentinel.controller;

import com.rickie.sentinel.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private EchoService echoService;

    @GetMapping("echo-feign/{str}")
    public String feign(@PathVariable String str) {
        return echoService.echo(str);
    }
}
