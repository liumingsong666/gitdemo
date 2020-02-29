package com.song.jwtspringstream.listener;

import com.song.jwtspringstream.mq.ConsumerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.SubscribableChannel;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;

@WebServlet  //必须添加@ServletComponentScan
public class ServletListener implements ServletContextListener {

    @Autowired
    private ConsumerMessage consumerMessage;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SubscribableChannel subscribableChannel = consumerMessage.ConsumerMessage();
        subscribableChannel.subscribe(new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                Object payload = message.getPayload();
                System.out.println(new String((byte[]) payload));
            }
        });
    }

    //也可以在类里添加@postconstruct初始化监听
}
