package com.chenddd.timeemail.controller;

import com.chenddd.timeemail.common.Result;
import com.chenddd.timeemail.entity.EmailSend;
import com.chenddd.timeemail.service.EmailAdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EmailAdmin)表控制层
 *
 * @author makejava
 * @since 2022-10-28 20:18:59
 */
@CrossOrigin
@RestController
@RequestMapping("/emailAdmin")
public class EmailAdminController{
    @Resource
    private EmailAdminService emailAdminService;

    /**
     *管理员登录
     * @param adminUser 用户名参数
     * @param password  用户密码参数
     * @return
     */
    @PostMapping("/login")
    public Result loginAdmin(String adminUser,String password){
        return emailAdminService.login(adminUser,password);
    }


    /**
     * 分页查询用户email
     * @param current
     * @param limit
     * @param email
     * @return
     */
    @PostMapping("findPage/{current}/{limit}")
    public Result findPage(@PathVariable Long current,
                           @PathVariable Long limit,
                           @RequestParam String email){
        Result page = emailAdminService.findPage(current, limit, email);

        return page;
    }

    /**
     * 查询全部记录
     * @return
     */
    @GetMapping("findAll")
    public Result findAll(){
       return emailAdminService.findAll();
    }


    /**
     * 更改emailSend数据
     * @param emailSend
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody EmailSend emailSend){
        Result result = emailAdminService.updateEmail(emailSend);

        return result;
    }

    /**
     * 单个id删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
       return emailAdminService.delete(id);
    }

    /**
     * 批量删除
     * @param idList
     * @return
     */
    @DeleteMapping("/batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
      return emailAdminService.batchDel(idList);
    }
}

