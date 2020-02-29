package com.song.jwtconfigclient.contro;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Reference  //刷新配置文件更改  通过post请求： 服务端/actuator/refresh
public class Controller {

    @Value("${you.name}")
    String name;   //需要放在bootstrap里面

    @RequestMapping("/test")
    public String test(){
        return name;
    }

    @RequestMapping("/test")  //测试分支
    public String test111(){
        return name;
    }

    @RequestMapping("/test")  //测试分支
    public String test111333(){
        return name;
    }

    @RequestMapping("/test")  //测试分支
    public String test111333344(){
        return name;
    }
}
