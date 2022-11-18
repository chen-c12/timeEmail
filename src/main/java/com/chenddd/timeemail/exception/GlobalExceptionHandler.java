package com.chenddd.timeemail.exception;

import com.chenddd.timeemail.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author: chenddd
 * Date: 2022/10/31 20:27
 * FileName: ExceptionHandler
 * Description:
 */
/**
 * Author: chenddd
 * Date: 2022/10/21 20:36
 * FileName: GlobalExceptionHandler
 * Description: 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result error(Exception e){
        log.error(e.getMessage());

        return Result.fail();
    }

    /**
     * 请求出错
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result RequestException(Exception e){
        log.error(e.getMessage());
        log.error("请求出错");
        return Result.fail("请求出错");
    }

}
