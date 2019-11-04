package com.rickie.springcloud.nacosexamples.controller;

import com.rickie.springcloud.nacosexamples.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EchoService echoService;

    @GetMapping("/index")
    public String index() {
        return restTemplate.getForObject("http://service-provider", String.class);
    }

    @GetMapping("/test")
    public String test() {
        return restTemplate.getForObject("http://service-provider/test", String.class);
    }

    @GetMapping("/sleep")
    public String sleep() {
        return restTemplate.getForObject("http://service-provider/sleep", String.class);
    }

    @GetMapping("/echo-rest/{str}")
    public String rest(@PathVariable String str) {
        return restTemplate.getForObject("http://service-provider/echo/" + str,
                String.class);
    }

    @GetMapping("/echo-feign/{str}")
    public String echo_feigh(@PathVariable String str) {
        return echoService.echo(str);
    }

    @GetMapping("/divide-feign")
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        return echoService.divide(a, b);
    }
}
