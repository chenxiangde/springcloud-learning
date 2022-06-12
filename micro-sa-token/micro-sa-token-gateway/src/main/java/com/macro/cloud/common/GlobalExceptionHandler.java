package com.macro.cloud.common;

import cn.dev33.satoken.exception.NotLoginException;
import com.macro.cloud.api.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * Created by cxd.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
 
    /**
     * 处理未登录的异常
     */
    @ResponseBody
    @ExceptionHandler(value = NotLoginException.class)
    public CommonResult handleNotLoginException(NotLoginException e) {
        return CommonResult.unauthorized(e.getMessage());
    }

}