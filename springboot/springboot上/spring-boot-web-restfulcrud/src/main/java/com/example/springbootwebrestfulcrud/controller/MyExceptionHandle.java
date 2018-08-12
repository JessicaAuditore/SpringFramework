package com.example.springbootwebrestfulcrud.controller;

import com.example.springbootwebrestfulcrud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//异常处理器
@ControllerAdvice
public class MyExceptionHandle {

    //订制异常处理并返回json数据 浏览器客户端都返回json，没有自适应效果
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String,Object> handleException(Exception e) {
//        Map<String,Object> map=new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //传入自己的错误状态码 4xx 5xx
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.notexist");
        map.put("message", "用户出错了");
        request.setAttribute("ext", map);
        //转发到/error
        return "forward:/error";
    }

}
