package com.chenddd.timeemail;

import com.chenddd.timeemail.entity.EmailSend;
import com.chenddd.timeemail.service.EmailSendService;
import com.chenddd.timeemail.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: chenddd
 * Date: 2022/11/6 17:04
 * FileName: sendEmail
 * Description:
 */
@SpringBootTest
public class sendEmail {
    @Resource
    private JwtUtil jwtUtil;
    @Test
    public void token(){
    }
}
