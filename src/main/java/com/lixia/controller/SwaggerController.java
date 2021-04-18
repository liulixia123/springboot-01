package com.lixia.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SwaggerController {
    @ApiOperation("Swagger Hello")
    @RequestMapping(value = "/hellos")
    @ResponseBody
    public String Hello(@ApiParam("用户名") String username) {
        return "hello" + username;
    }
}
