package com.info.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.info.domain.entity.User;
import com.info.domain.entity.ValidateToken;

public interface IUserService extends UserDetailsService{

    User creatNewUser(User user);

    void saveValidateToken(ValidateToken token);

    ValidateToken findValidateToken(String token);

    void saveRegistratedUser(User user);

}
