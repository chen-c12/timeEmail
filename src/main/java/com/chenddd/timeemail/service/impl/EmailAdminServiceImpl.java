package com.chenddd.timeemail.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenddd.timeemail.common.EmailCheck;
import com.chenddd.timeemail.common.Result;
import com.chenddd.timeemail.common.admin.AdminSearch;
import com.chenddd.timeemail.dao.EmailAdminDao;
import com.chenddd.timeemail.entity.EmailAdmin;
import com.chenddd.timeemail.entity.EmailSend;
import com.chenddd.timeemail.service.EmailAdminService;
import com.chenddd.timeemail.service.EmailSendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EmailAdmin)表服务实现类
 *
 * @author makejava
 * @since 2022-10-28 20:19:07
 */
@Service("emailAdminService")
public class EmailAdminServiceImpl extends ServiceImpl<EmailAdminDao, EmailAdmin> implements EmailAdminService {

    @Resource
    private EmailSendService emailSendService;
    @Resource
    private EmailCheck emailCheck;
    @Resource
    private AdminSearch adminSearch;

    /**
     *用户登录service层
     * @param adminUser
     * @param password
     * @return
     */
    @Override
    public Result login(String adminUser, String password) {
        Long id = adminSearch.getOneAdmin(adminUser, password);
        if (adminSearch.getAdmin(adminUser,password)){
            StpUtil.login(id);
           return Result.successLogin("登录成功");
        }else {
           return Result.failLogin("账号或密码错误");
        }
    }


    /**
     * 分页查询emailSend数据
     * @param current
     * @param limit
     * @return
     */
    @Override
    public Result findPage(Long current, Long limit,String email) {
        Page<EmailSend> page = new Page<>(current,limit);
        LambdaQueryWrapper<EmailSend> wrapper = new LambdaQueryWrapper<EmailSend>();
        wrapper.like(EmailSend::getEmail,email);
        Page<EmailSend> sendPage = emailSendService.page(page, wrapper);
        return Result.ok(sendPage);
    }

    /**
     * 查询全部(不分页)
     * @return
     */
    @Override
    public Result findAll() {
        List<EmailSend> list = emailSendService.list();
        return Result.ok(list);
    }

    /**
     * 更新
     * @param emailSend
     * @return
     */
    @Override
    public Result updateEmail(EmailSend emailSend) {
        if (emailCheck.check(emailSend.getEmail())){
            boolean b = emailSendService.updateById(emailSend);
            if (b){
                return Result.ok("修改成功");
            }else {
                return Result.fail("修改失败");
            }
        }else {
            return Result.fail("邮箱不合法");
        }

    }

    /**
     * 根据id删除单个
     * @param id
     * @return
     */
    @Override
    public Result delete(Long id) {
        boolean b = emailSendService.removeById(id);
        if (b){
            return Result.ok("删除成功");
        }else {
            return Result.fail("删除失败");
        }
    }

    /**
     * 批量删除
     * @param list
     * @return
     */
    @Override
    public Result batchDel(List<Long> list) {
        boolean b = emailSendService.removeByIds(list);
        if (b){
            return Result.ok("删除成功");
        }else {
            return Result.fail("删除失败");
        }
    }
}

