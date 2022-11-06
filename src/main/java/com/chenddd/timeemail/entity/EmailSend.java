package com.chenddd.timeemail.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (EmailSend)表实体类
 *
 * @author makejava
 * @since 2022-10-25 13:17:06
 */
@Data
public class EmailSend extends Model<EmailSend> {
    //id
    private Long id;

    private String email;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //删除标记（0:不可用 1:可用）
    @TableLogic
    private Integer isDeleted;


}

