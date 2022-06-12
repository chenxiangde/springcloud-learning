package com.macro.cloud.api;

/**
 * 封装API的错误码
 * Created by cxd.
 */
public interface IErrorCode {

    long getCode();

    String getMessage();
}