package com.rickie.sentinel.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class EchoServiceFallbackFactory implements FallbackFactory<EchoServiceFallback> {
    @Override
    public EchoServiceFallback create(Throwable throwable) {
        return new EchoServiceFallback(throwable);
    }
}
