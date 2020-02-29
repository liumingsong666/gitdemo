package com.song.jwtspringstream.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerMessage {

    @Input("这是交换机名")  //和生产方一样
    SubscribableChannel ConsumerMessage();
}
