package com.rickie.sentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EchoController {
    @GetMapping("/echo/{str}")
    public String echo(@PathVariable String str, HttpServletRequest request) {
        return "Hello, " + str + ". Port is " + request.getLocalPort() + ".";
    }
}
