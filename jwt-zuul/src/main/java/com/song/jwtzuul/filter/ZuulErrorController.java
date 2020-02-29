package com.song.jwtzuul.filter;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZuulErrorController implements ErrorController {

    //配置错误请求接口，必须实现该接口，不然会报创建类错误，spring已经使用该请求路径
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String error(){
        return "错误页面";
    }
}
