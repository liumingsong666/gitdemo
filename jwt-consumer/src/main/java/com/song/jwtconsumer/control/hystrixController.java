package com.song.jwtconsumer.control;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hystrix")
public class hystrixController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
   // @HystrixCommand(fallbackMethod = "jiangJi")
    //设置降级方式，有信号量和线程池，这里通过线程池，降级启动的线程不一样，后面为100毫秒无响应就降级
    @HystrixCommand(fallbackMethod = "jiangji",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "100")})
    public String test1(@RequestParam String name){
        System.out.println(Thread.currentThread().getName());
        return restTemplate.getForObject("http://JWT-PROVIDER/test1/"+name,String.class);
    }

    public String jiangJi(String name){
        System.out.println(Thread.currentThread().getName());
        return name+"降级了";
    }
}
