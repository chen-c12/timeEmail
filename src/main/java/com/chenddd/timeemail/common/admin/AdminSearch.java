package com.chenddd.timeemail.common.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chenddd.timeemail.dao.EmailAdminDao;
import com.chenddd.timeemail.entity.EmailAdmin;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Author: chenddd
 * Date: 2022/11/3 9:59
 * FileName: AdminSearch
 * Description:
 */
@Component
public class AdminSearch {
    @Resource
    private EmailAdminDao emailAdminDao;

    public Boolean getAdmin(String adminUser,String password){
        LambdaQueryWrapper<EmailAdmin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EmailAdmin::getUsername,adminUser);
        wrapper.eq(EmailAdmin::getPassword,password);
        return emailAdminDao.exists(wrapper);
    }

    public Long getOneAdmin(String adminUser,String password){
        LambdaQueryWrapper<EmailAdmin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EmailAdmin::getUsername,adminUser);
        EmailAdmin emailAdmin = emailAdminDao.selectOne(wrapper);
        Long id = emailAdmin.getId();
        return id;
    }
}
