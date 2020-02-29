package com.song.jwtspringstream.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SendMessage {

    @Output("这是交换机名")
    MessageChannel sendMessage();
}
