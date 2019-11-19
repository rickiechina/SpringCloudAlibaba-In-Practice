package com.rickie.sentinel.fallback;

import com.rickie.sentinel.service.EchoService;

public class EchoServiceFallback implements EchoService {
    private Throwable throwable;

    EchoServiceFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String echo(String str) {
        return "consumer-fallback-default-str: "  + throwable.getMessage();
    }
}
