package com.macro.cloud.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.macro.cloud.api.CommonResult;
import com.macro.cloud.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义Oauth2获取令牌接口
 * Created by cxd.
 */
@Api(tags = "UserController", description = "获取令牌接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestParam String username, @RequestParam String password) {
        SaTokenInfo saTokenInfo = userService.login(username, password);
        if (saTokenInfo == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", saTokenInfo.getTokenValue());
        tokenMap.put("tokenHead", saTokenInfo.getTokenName());
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "当前会话注销登录")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public CommonResult logout() {
        StpUtil.logout();
        return CommonResult.success("注销登录");
    }

    @ApiOperation(value = "查询当前登录状态")
    @RequestMapping(value = "/isLogin", method = RequestMethod.GET)
    public CommonResult isLogin() {
        return CommonResult.success(StpUtil.isLogin());
    }

    @ApiOperation(value = "检验当前会话是否已经登录, 如果未登录，则抛出异常NotLoginException")
    @RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
    public CommonResult checkLogin() {
        StpUtil.checkLogin();
        return CommonResult.success("已经登录");
    }
}