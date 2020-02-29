package com.song.jwtzuul.filter;


import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulFilter03 extends ZuulAbstractFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 10;
    }


    @Override
    public Object run() throws ZuulException {
        System.out.println("后置过滤器实现了："+currentContext.getRequest().getRequestURL());
        return null;
    }
}
