package com.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.entity.EduLevel;
import com.info.domain.repository.EduLevelRepository;
import com.info.service.IEduLevelService;

@Service
public class EduLevelService implements IEduLevelService {

	@Autowired
	private EduLevelRepository eduLevelRepository;
	
	@Override
	public List<EduLevel> getAll() {
		return eduLevelRepository.findAll();
	}

}
