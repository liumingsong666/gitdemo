package com.song.jwtprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class JwtProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtProviderApplication.class, args);
    }

}
