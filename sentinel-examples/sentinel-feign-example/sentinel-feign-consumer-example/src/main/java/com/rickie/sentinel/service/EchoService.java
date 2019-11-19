package com.rickie.sentinel.service;

import com.rickie.sentinel.fallback.EchoServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="service-provider", fallbackFactory = EchoServiceFallbackFactory.class)
public interface EchoService {
    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String str);
}
