package com.song.springevent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringEventTest {
    public static void main(String[] args) {

        //扫描这个类使注解生效
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringEventTest.class);
        annotationConfigApplicationContext.publishEvent(new Stu("nimen"));
    }
}
