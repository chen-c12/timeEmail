package com.chenddd.timeemail.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (EmailAdmin)表实体类
 *
 * @author makejava
 * @since 2022-10-28 20:19:06
 */
@Data
public class EmailAdmin extends Model<EmailAdmin> {
    
    private Long id;
    
    private String username;
    
    private String password;
    
    private String email;
    
    private Date updatetime;
    
    private Date createtime;


    }

