package com.song.jwtspringstream.contro;

import com.song.jwtspringstream.mq.SendMessage;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private SendMessage sendMessage;

    @RequestMapping("send/{message}")
    public String send(@PathVariable String message){
        MessageChannel messageChannel = sendMessage.sendMessage();  //会创建代理对象
        messageChannel.send(new GenericMessage<>(message));
        return "success";
    }
}
