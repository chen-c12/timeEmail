package com.chenddd.timeemail.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenddd.timeemail.common.Result;
import com.chenddd.timeemail.common.email.EmailCode;
import com.chenddd.timeemail.common.email.SendEmail;
import com.chenddd.timeemail.common.ValidateCodeUtils;
import com.chenddd.timeemail.dao.EmailSendDao;
import com.chenddd.timeemail.entity.EmailSend;
import com.chenddd.timeemail.service.EmailSendService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * (EmailSend)表服务实现类
 *
 * @author makejava
 * @since 2022-10-25 13:17:07
 */
@Service("emailSendService")
public class EmailSendServiceImpl extends ServiceImpl<EmailSendDao, EmailSend> implements EmailSendService {


    @Resource
    private EmailSendDao emailSendDao;
    @Resource
    private EmailCode emailCode;
    @Resource
    private RedisTemplate redisTemplate;


    /**
     * 添加邮箱地址
     * @param email
     * @return
     */
    @Override
    public Result addEmail(String email,String code){
        String vail = redisTemplate.opsForValue().get(email).toString();
        if (!code.equals(vail)){
            return Result.fail("验证码错误");
        }else {
            LambdaQueryWrapper<EmailSend> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(EmailSend::getEmail,email);
            long count = this.count(wrapper);
            if (count != 0){
                return Result.fail("邮箱重复了");
            }else {
                EmailSend emailSend = new EmailSend();
                emailSend.setEmail(email);
                if (StringUtils.hasText(email)) {
                    boolean save = this.save(emailSend);
                    return Result.ok("添加成功");
                } else {
                    return Result.fail("添加失败");
                }
            }
        }
    }


    /**
     * 删除邮箱实现类
     * @param email
     * @return
     */
    @Override
    public Result deleteEmail(String email) {
        LambdaQueryWrapper<EmailSend> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EmailSend::getEmail,email);
        EmailSend emailSend = emailSendDao.selectOne(wrapper);
        Long id = emailSend.getId();
        int i = emailSendDao.deleteById(id);
        if (i!=0){
            return Result.ok("删除成功!");
        }else {
            return Result.fail("没有此邮箱！");
        }
    }

    /**
     * 查询邮箱是否存在
     * @param email
     * @return
     */
    @Override
    public Result selectByEmail(String email) {
        LambdaQueryWrapper<EmailSend> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EmailSend::getEmail,email);
        EmailSend emailIsExit = emailSendDao.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(emailIsExit)){
            return Result.fail("邮箱地址已存在！");
        }else {
            return Result.ok("邮箱不存在，可添加");
        }
    }

    /**
     * 发送验证码
     * @return
     */
    @Override
    public Result sendCode(String email) {
        Integer integer = ValidateCodeUtils.generateValidateCode(6);
        redisTemplate.opsForValue().set(email,integer,300,TimeUnit.SECONDS);
            emailCode.sendMail(email,integer);
            return Result.ok("发送成功");
    }


}

