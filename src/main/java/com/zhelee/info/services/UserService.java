package com.zhelee.info.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhelee.info.dao.UserDao;
import com.zhelee.info.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
}
