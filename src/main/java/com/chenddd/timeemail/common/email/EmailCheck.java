package com.chenddd.timeemail.common.email;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: chenddd
 * Date: 2022/10/28 22:22
 * FileName: EmailCheck
 * Description:
 */
@Component
public class EmailCheck {
    public Boolean check(String email){
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern compile = Pattern.compile(check);
        Matcher matcher = compile.matcher(email);
        boolean matches = matcher.matches();
        return matches;
    }
}
