package com.song.jwtzuul.filter;

import com.netflix.zuul.exception.ZuulException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Enumeration;
import java.util.Map;

//@Component
public class ZuulFilter02 extends ZuulAbstractFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 20;
    }

@Autowired
private RedisTemplate<String,String> redisTemplate;

    @SneakyThrows
    @Override
    public Object run() {
        System.out.println("前置过滤器2实现了");
        String test = currentContext.getRequest().getParameter("test");
        Map entries = redisTemplate.opsForHash().entries("test");
        if(entries!=null){
            //获取服务和请求  动态路由的配置，从redis里面获取
            String serviceId = (String) entries.get("serviceId");
            String uri = (String) entries.get("uri");
            System.out.println("获取的服务为："+serviceId+uri);
            Enumeration<String> parameterNames = currentContext.getRequest().getParameterNames();
            while (parameterNames.hasMoreElements()){
                String paramName = parameterNames.nextElement();
                String should = "{"+paramName+"}";
                String parameter = currentContext.getRequest().getParameter(paramName);
                uri=uri.replace(should,parameter);
            }
            currentContext.put(FilterConstants.SERVICE_ID_KEY,serviceId);
            currentContext.put(FilterConstants.REQUEST_URI_KEY,uri);
        }else {
            currentContext.setSendZuulResponse(false);
            currentContext.getResponse().sendError(602,"没有该服务");
        }
        return null;
    }
}
