package com.macro.cloud.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.macro.cloud.api.CommonResult;
import com.macro.cloud.domain.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取登录用户信息接口
 * Created by cxd.
 */
@Api(tags = "UserController", description = "获取登录用户信息")
@RestController
@RequestMapping("/user")
public class UserController{

    @ApiOperation(value = "获取登录用户信息")
    @GetMapping("/info")
    @ResponseBody
    public CommonResult<UserDTO> userInfo() {
        UserDTO userDTO = (UserDTO) StpUtil.getSession().get("userInfo");
        return CommonResult.success(userDTO);
    }
}