package com.song.jwtspringstream.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class MqListener {

    @StreamListener("这是交换机名")  //最常用的方式启动消费者
    public void consumer(String message){

    }
}
