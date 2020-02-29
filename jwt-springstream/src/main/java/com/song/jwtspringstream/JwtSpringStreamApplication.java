package com.song.jwtspringstream;

import com.song.jwtspringstream.mq.ConsumerMessage;
import com.song.jwtspringstream.mq.SendMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({SendMessage.class, ConsumerMessage.class}) //包含discover,feign,break的注解
@ServletComponentScan("com.song.jwtspringstream.listener.ServletListener")
public class JwtSpringStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtSpringStreamApplication.class, args);
    }

}
