package com.info.service.impl;

import com.info.domain.entity.Employee;
import com.info.domain.entity.User;
import com.info.domain.entity.ValidateToken;
import com.info.domain.repository.UserRepository;
import com.info.domain.repository.ValidateTokenRepository;
import com.info.service.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidateTokenRepository tokenRepository;

    /**
     *  邮箱登录，邮箱地址替换用户名称
     * @param email
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;

    }

    /**
     *  创建一个新的账户
     * @param user
     * @return
     */
    @Override
    public User creatNewUser(User user) {
        if (isEmailExist(user.getEmail())){
            return null;
        }else {
            return userRepository.save(user);
        }
    }

    /**
     *  保存验证令牌
     * @param validateToken
     */
    @Override
    public void saveValidateToken(ValidateToken validateToken) {
        tokenRepository.save(validateToken);
    }

    @Override
    public ValidateToken findValidateToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    public void saveRegistratedUser(User user) {
        userRepository.save(user);
    }

    /**
     *  判断邮箱是否已经存在
     * @param email
     * @return
     */
    public boolean isEmailExist(String email){
        User user = userRepository.findByEmail(email);
        if (user==null){
            return false;
        }else {
            return true;
        }
    }

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
