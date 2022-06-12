package com.macro.cloud.common;

import cn.dev33.satoken.exception.DisableLoginException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.macro.cloud.api.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 * Created by cxd.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
 
    // 全局异常拦截
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public CommonResult handlerException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (e instanceof NotLoginException) {// 如果是未登录异常
                NotLoginException ee = (NotLoginException) e;
                return CommonResult.unauthorized(ee.getMessage());
            } else if (e instanceof NotRoleException) {// 如果是角色异常
                NotRoleException ee = (NotRoleException) e;
                return CommonResult.forbidden(ee.getMessage());
            } else if (e instanceof NotPermissionException) {// 如果是权限异常
                NotPermissionException ee = (NotPermissionException) e;
                return CommonResult.forbidden(ee.getMessage());
            } else if (e instanceof DisableLoginException) {// 如果是被封禁异常
                DisableLoginException ee = (DisableLoginException) e;
                return CommonResult.forbidden(ee.getMessage());
            } else {// 普通异常，输出：500 + 异常信息
                return CommonResult.failed(e.getMessage());
            }
        } catch (Exception ex) {
            return CommonResult.failed(e.getMessage());
        }
    }
}