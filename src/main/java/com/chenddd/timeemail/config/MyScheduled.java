package com.chenddd.timeemail.config;

import com.chenddd.timeemail.common.SendEmail;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Author: chenddd
 * Date: 2022/10/25 13:45
 * FileName: MyScheduled
 * Description:
 */
@Component
public class MyScheduled {
    @Resource
    private SendEmail sendEmail;


    /*定时执行任务方法 每天执行该任务*/
    @Scheduled(cron ="0 30 12 * * *")
    public void dsrw(){
        sendEmail.sendMail();
    }
}

