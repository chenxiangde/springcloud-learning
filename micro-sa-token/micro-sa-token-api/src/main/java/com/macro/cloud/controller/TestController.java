package com.macro.cloud.controller;

import com.macro.cloud.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 * Created by cxd.
 */
@Api(tags = "TestController", description = "测试接口")
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "测试接口")
    @GetMapping("/hello")
    @ResponseBody
    public CommonResult hello() {
        return CommonResult.success("Hello World.");
    }
}