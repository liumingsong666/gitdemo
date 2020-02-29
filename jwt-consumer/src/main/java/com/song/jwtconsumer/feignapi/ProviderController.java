package com.song.jwtconsumer.feignapi;

import com.song.param.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "JWT-PROVIDER",fallback = ProviderControllerFallback.class)  //必须在启动类上开启feign支持，这个注解才生效
public interface ProviderController {

    //这里是先找的方法，通过方法里的属性向上找地址，和springMvc相反
    @GetMapping("/test1/{name}")
    String test1(@PathVariable String name);

    //如果添加@requestParam 这代表key--value类型
    @PostMapping("/test2")
    String test2(@RequestBody User user);

    @PostMapping("/test3")
    User test3(@RequestBody User user);
}
