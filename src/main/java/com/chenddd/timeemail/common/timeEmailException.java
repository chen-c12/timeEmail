package com.chenddd.timeemail.common;

import lombok.Data;

/**
 * Author: chenddd
 * Date: 2022/10/31 20:36
 * FileName: timeEmailException
 * Description:
 */
@Data
public class timeEmailException extends RuntimeException{
    private Integer code;

    /**
     * 通过状态码和错误消息创建异常对象
     * @param message
     * @param code
     */
    public timeEmailException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public timeEmailException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "timeEmailException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
