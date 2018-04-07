package com.info.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {

	@Autowired
	private SysUserRepository sysUserRepository;
	
	public SysUser findByName(String userName) {
		
		return sysUserRepository.findByName(userName);
	}

}
