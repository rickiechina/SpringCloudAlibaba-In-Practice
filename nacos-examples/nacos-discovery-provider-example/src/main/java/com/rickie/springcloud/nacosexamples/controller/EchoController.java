package com.rickie.springcloud.nacosexamples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EchoController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/")
    public ResponseEntity index() {
        return new ResponseEntity("index error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/test")
    public ResponseEntity test() {
        return new ResponseEntity("error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/sleep")
    public String sleep() {
        try {
            Thread.sleep(1000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        return "hello Nacos Discovery " + string;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        return String.valueOf(a / b);
    }

    @GetMapping("/getInstances")
    public List<ServiceInstance> getInstances() {
        return this.discoveryClient.getInstances("service-provider");
    }
}
