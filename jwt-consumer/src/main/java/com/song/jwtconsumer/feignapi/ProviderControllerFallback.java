package com.song.jwtconsumer.feignapi;

import com.song.param.User;
import org.springframework.stereotype.Component;

@Component  //必须添加这个注解，不然不能降级
public class ProviderControllerFallback implements ProviderController {
    @Override
    public String test1(String name) {
        return "feign降级成功";
    }

    @Override
    public String test2(User user) {
        return null;
    }

    @Override
    public User test3(User user) {
        return null;
    }
}
