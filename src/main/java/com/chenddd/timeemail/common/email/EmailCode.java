package com.chenddd.timeemail.common.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Author: chenddd
 * Date: 2022/11/3 15:32
 * FileName: EmailCode
 * Description:
 */
@Component
public class EmailCode {

    @Resource
    JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String emailSender;

    /**
     * 发送验证码
     * @param email 邮箱
     * @param msg 验证码
     */
    public void sendMail(String email,Integer msg){
        //创建简单邮件消息
        SimpleMailMessage message=new SimpleMailMessage();
        //邮件标题
        message.setSubject("验证码");
        //邮件内容
        message.setText("你正在添加timeEmail邮箱，本次验证码为："+msg+",两分钟内有效，若非本人操作，请忽略");
        //谁发的
        message.setFrom(emailSender);
        //谁要接收 email chenddd2022@163.com
        message.setTo(email);

        javaMailSender.send(message);
    }
}
