package com.chenddd.timeemail.interceptor;

/**
 * Author: chenddd
 * Date: 2022/11/18 11:44
 * FileName: JWTInterceptor
 * Description:
 */

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.chenddd.timeemail.entity.EmailAdmin;
import com.chenddd.timeemail.service.EmailAdminService;
import com.chenddd.timeemail.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: token 拦截器
 */
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {
    @Resource
    private EmailAdminService emailAdminService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        System.out.println(token);
        log.info("token：" + token);

        if (token == null) {
            log.error("token为空");
        }
        try {
            Long userId = JwtUtil.getUserId(token);
            EmailAdmin byId = emailAdminService.getById(userId);
            if (userId.equals(byId.getId())){
                return true;
            }
        } catch (SignatureVerificationException e) {
            log.error("无效签名");
            return false;
        } catch (TokenExpiredException e) {
            log.error("token过");
            return false;
        } catch (AlgorithmMismatchException e) {
            log.error("token算法不一致");
            return false;
        } catch (Exception e) {
            log.error("token无效");
            return false;
        }
        return true;
    }
}