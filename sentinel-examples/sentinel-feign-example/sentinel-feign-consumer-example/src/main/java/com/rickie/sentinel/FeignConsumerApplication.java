package com.rickie.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class FeignConsumerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }
}
