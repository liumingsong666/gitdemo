package com.song.jwtzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public abstract class ZuulAbstractFilter extends ZuulFilter {

    RequestContext currentContext ;

    @Override
    public boolean shouldFilter() {
        currentContext = RequestContext.getCurrentContext();
        return currentContext.sendZuulResponse();
    }

}
