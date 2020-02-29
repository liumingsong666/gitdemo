package com.song.springevent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class A {

    //开启观察者模式，程序内部的推送
    @EventListener
    public String test(Stu stu){
        System.out.println(stu.name);
        return stu.getName();
    }
}
