package com.cloud.demo.advice;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author dingwq
 * @Date 2020/8/26 19:14
 * @Description hystrix全局异常拦截处理
 */
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = HystrixBadRequestException.class)
    public String errorHandler1(HystrixBadRequestException ex) {
        return "HystrixBadRequestException -> yes";
    }

    @ExceptionHandler(value = HystrixRuntimeException.class)
    public String errorHandler2(HystrixRuntimeException ex) {
        return "HystrixRuntimeException -> yes";
    }
}
