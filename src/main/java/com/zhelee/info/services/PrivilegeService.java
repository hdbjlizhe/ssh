package com.zhelee.info.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhelee.info.entities.Privilege;
import com.zhelee.info.repository.PrivilegeRepository;

@Service
public class PrivilegeService {
	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	public List<Privilege> findAll() {
		return privilegeRepository.findAll();
	}
}
