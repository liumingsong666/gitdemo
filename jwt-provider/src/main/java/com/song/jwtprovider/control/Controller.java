package com.song.jwtprovider.control;


import com.song.param.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    int c=0;
    public static int i ;
    static final int[] b ={1,2,3};

    @GetMapping("/test1/{name}")
    public String test1(@PathVariable String name){

        return name;
    }

    @PostMapping("/test2")
    public String test2(@RequestBody User user){

        return user.getName();
    }

    @PostMapping("/test3")
    public User test3(@RequestBody User user){

        return user;
    }

    @RequestMapping("test/{a}")
    public int test(@PathVariable int a){
        i=a;
        b[0]=a;
        c=a;
        System.out.println("i，b,c为："+i+""+b[0]+""+c);
        return a;
    }

    @RequestMapping("test4")
    public int test4(){
        System.out.println("i，b,c为："+i+""+b[0]+""+c);
        return 1;
    }
}
