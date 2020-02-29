package com.song.jwtconsumer;

import com.song.jwtconsumer.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(value = "JWT-PROVIDER",configuration = RibbonConfig.class)
//给JWT-PROVIDER服务提供一个负债均衡 配置类，可以不写，这个地方配置的 随机
//也可以通过自定义注解排除 ：componentScan里面排除不需要的类
@EnableFeignClients
@EnableCircuitBreaker
public class JwtConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced  //不加这个注解是无法通过服务名找到服务的，会报500找不到host错误
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
