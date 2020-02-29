package com.song.jwtconsumer.control;

import com.song.jwtconsumer.feignapi.ProviderController;
import com.song.param.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/feign")
public class FeignController {


    @Autowired
    private ProviderController providerController;

    @GetMapping("/test1/{name}")
    public String test1(@PathVariable String name){
        log.info("test1:{}",name);
        return providerController.test1(name);
    }

    @PostMapping("/test2/{name}")
    public String test2(@PathVariable String name){
        //对象必须要有无参构造，不然无法创建实例对象
        User user = new User(name);
        return providerController.test2(user);
    }

    @PostMapping("/test3")
    public User test3(@RequestBody User user){
        //postman发送对象，选择header中为：ContentType--application/json  选择body里面的raw
        log.info(user.getName());
        return providerController.test3(user);
    }

    //这个为ribbon提供的，eureka里面提供了ribbon,不用导ribbon依赖
    @Autowired
    private LoadBalancerClient client;
    @GetMapping("test4")
    public int test4(){
        ServiceInstance choose = client.choose("JWT-PROVIDER");
        return choose.getPort();
    }
}
