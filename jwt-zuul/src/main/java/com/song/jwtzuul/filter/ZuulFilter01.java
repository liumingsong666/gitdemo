package com.song.jwtzuul.filter;


import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.exception.ZuulException;
import lombok.SneakyThrows;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulFilter01 extends ZuulAbstractFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 10;
    }

//创建令牌桶
    RateLimiter rateLimiter=RateLimiter.create(10);

    @SneakyThrows
    @Override
    public Object run() throws ZuulException {
        if(rateLimiter.tryAcquire()){
            //zuul自己将上下文存储起来了
            HttpServletRequest request = currentContext.getRequest();
            Object name = request.getParameter("test");
            System.out.println("前置过滤器实现了,地址为："+request.getRequestURL()+"---"+request.getRequestURI());
            if(name==null || name.equals("")){
                //告诉后面的filter不用执行了，后面filter可以直接取出来
               // currentContext.setSendZuulResponse(false);
                currentContext.getResponse().setContentType("application/json;charset=utf-8");
                //currentContext.setResponseBody("没有得到参数test1");
                currentContext.getResponse().sendError(603,"没有获取到参数test");
            }
        }else {
            currentContext.getResponse().setContentType("application/json;charset=utf-8");
            currentContext.getResponse().sendError(600,"没有获取到令牌");
        }

        return null;
    }
}
