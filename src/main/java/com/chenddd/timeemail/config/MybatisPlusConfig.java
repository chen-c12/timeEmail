package com.chenddd.timeemail.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;


import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Author: chenddd
 * Date: 2022/10/28 21:00
 * FileName: MybatisPlusConfig
 * Description:
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.chenddd.timeemail.dao")
public class MybatisPlusConfig {

    /**
     *分页插件
     */

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MARIADB));
        return interceptor;
    }
}
