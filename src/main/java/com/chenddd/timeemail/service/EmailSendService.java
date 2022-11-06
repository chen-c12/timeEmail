package com.chenddd.timeemail.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenddd.timeemail.common.Result;
import com.chenddd.timeemail.entity.EmailSend;

/**
 * (EmailSend)表服务接口
 *
 * @author makejava
 * @since 2022-10-25 13:17:07
 */
public interface EmailSendService extends IService<EmailSend> {
    /**
     * 添加邮箱地址
     * @param email
     * @return
     */
    Result addEmail(String email,String code);

    /**
     * 删除邮箱用户
     * @param email
     * @return
     */
    Result deleteEmail(String email);

    /**
     * 查找邮箱是否存在
     * @param email
     * @return
     */
    Result selectByEmail(String email);


    Result sendCode(String email);
}

