package com.chenddd.timeemail.controller;

import com.chenddd.timeemail.common.EmailCheck;
import com.chenddd.timeemail.common.Result;
import com.chenddd.timeemail.service.EmailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;



/**
 * (EmailSend)表控制层
 *
 * @author chenddd
 * @since 2022-10-25 13:16:58
 */
@RestController
//跨域
@CrossOrigin
public class EmailSendController{
    @Autowired
    private EmailSendService emailSendService;
    @Resource
    private EmailCheck emailCheck;

    /**
     * 邮箱添加
     * @param email
     * @return json
     */
    /*@PutMapping("{email}")
    public Result addEmail(@PathVariable String email){
        if (emailCheck.check(email)){
            Result result = emailSendService.addEmail(email);
            return result;
        }else {
            return Result.fail("邮箱不合法");
        }
    }*/

    @PutMapping("{email}/{code}")
    public Result addEmail(@PathVariable String email,
                           @PathVariable String code){
        if (emailCheck.check(email)){
            Result result = emailSendService.addEmail(email,code);
            return result;
        }else {
            return Result.fail("邮箱不合法");
        }
    }

    /**
     * 邮箱账号删除
     * @param email
     * @return
     */
    @DeleteMapping("{email}")
    public Result deleteEmail(@PathVariable String email){
        Result result = emailSendService.deleteEmail(email);
        return result;
    }


    /**
     * 查询邮箱是否存在
     * @param email
     * @return
     */
    @GetMapping("/exitEmail/{email}")
    public Result exitEmail(@PathVariable String email){
        Result result = emailSendService.selectByEmail(email);
        return result;
    }

    /**
     * 发送验证
     * @param email
     * @return
     */
    @PostMapping("/code")
    public Result sendCode(String email){
        Result code = emailSendService.sendCode(email);
        return code;
    }
}

