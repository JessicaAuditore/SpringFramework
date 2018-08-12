package com.example.springbootdatajpa.controller;

import com.example.springbootdatajpa.entity.User;
import com.example.springbootdatajpa.repository.UserReposity;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "demo演示", description = "主要提供演示测试相关的接口API")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserReposity userReposity;

    @ApiOperation("根据ID获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", dataType = "int", required = true, value = "用户的id", defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 401, message = "权限校验不通过"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @GetMapping(value = "/getUser/{id}")
    public User getUser(@PathVariable(value = "id") Integer id) {
        return userReposity.findById(id).orElse(null);
    }

    @ApiOperation("插入用户")
//    @ApiImplicitParams({
////            @ApiImplicitParam(paramType = "query", name = "user", dataType = "User", required = true, value = "用户", defaultValue = "null")
////    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 401, message = "权限校验不通过"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @GetMapping(value = "/insertUser")
    public User insertUser(User user){
        User u=userReposity.save(user);
        return u;
    }
}
