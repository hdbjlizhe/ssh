package com.info.service;

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

}
