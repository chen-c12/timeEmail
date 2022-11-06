package com.chenddd.timeemail.exception;

import cn.dev33.satoken.exception.NotLoginException;
import com.chenddd.timeemail.common.Result;
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
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result error(Exception e){
        e.printStackTrace();

        return Result.fail();
    }

    // 全局异常拦截（拦截项目中的NotLoginException异常）
    @ExceptionHandler(NotLoginException.class)
    public Result handlerNotLoginException(NotLoginException nle)
            throws Exception {

        // 打印堆栈，以供调试
        nle.printStackTrace();

        // 判断场景值，定制化异常信息
        String message = "";
        if(nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未提供token";
        }
        else if(nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token无效";
        }
        else if(nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "token已过期";
        }
        else if(nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "token已被顶下线";
        }
        else if(nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "token已被踢下线";
        }
        else {
            message = "当前会话未登录";
        }

        // 返回给前端
        return Result.fail(message);
    }

}
