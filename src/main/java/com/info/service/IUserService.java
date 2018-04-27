package com.info.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.info.domain.entity.User;
import com.info.domain.entity.ValidateToken;

public interface IUserService extends UserDetailsService{
	//创建新用户
    User creatNewUser(User user);
    //保存验证令牌
    void saveValidateToken(ValidateToken token);
    //查询token
    ValidateToken findValidateToken(String token);
    //保存注册用户
    void saveRegistratedUser(User user);
    //用户名查找用户
    User findByUsername(String username);
    //邮箱查找用户
    User findByEmail(String email);
    //查找登录用户
	User getLoginEmployee(HttpServletRequest request);

}
