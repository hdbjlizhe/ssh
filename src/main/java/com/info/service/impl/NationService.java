package com.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.entity.Nation;
import com.info.domain.repository.NationRepository;
import com.info.service.INationService;

@Service
public class NationService implements INationService {

	@Autowired
	private NationRepository nationRepository;
	
	@Override
	public List<Nation> getAll() {
		
		return nationRepository.findAll();
	}

}
