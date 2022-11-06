package com.chenddd.timeemail.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenddd.timeemail.common.Result;
import com.chenddd.timeemail.entity.EmailAdmin;
import com.chenddd.timeemail.entity.EmailSend;


import java.util.List;

/**
 * (EmailAdmin)表服务接口
 *
 * @author makejava
 * @since 2022-10-28 20:19:07
 */
public interface EmailAdminService extends IService<EmailAdmin> {

    Result login(String adminUser, String password);

    Result findPage(Long current, Long limit,String email);

    Result findAll();

    Result updateEmail(EmailSend emailSend);

    Result delete(Long id);

    Result batchDel(List<Long> list);



}

