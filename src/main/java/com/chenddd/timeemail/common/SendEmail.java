package com.chenddd.timeemail.common;

import com.chenddd.timeemail.entity.EmailSend;
import com.chenddd.timeemail.service.EmailSendService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: chenddd
 * Date: 2022/10/25 14:39
 * FileName: SendEmail
 * Description:
 */
@Component
public class SendEmail {
    @Resource
    JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String emailSender;
    @Resource
    private EmailSendService emailSendService;

    /**
     *@author chenddd
     * 邮件的发送
     */
    public void sendMail(){
        //创建简单邮件消息
        SimpleMailMessage message=new SimpleMailMessage();
        //邮件标题
        message.setSubject("打卡啦！！！");
        //邮件内容
        message.setText("不打卡就毕不了业啦！！");
        //谁发的
        message.setFrom(emailSender);
        //谁要接收 email chenddd2022@163.com

        List<EmailSend> list = emailSendService.list();
        for (EmailSend emailSend : list) {
            String email = emailSend.getEmail();
            message.setTo(email);
            javaMailSender.send(message);
        }
    }
}
