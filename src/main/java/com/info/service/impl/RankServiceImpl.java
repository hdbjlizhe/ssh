package com.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.entity.Rank;
import com.info.domain.repository.RankRepository;
import com.info.service.IRankService;
@Service
public class RankServiceImpl implements IRankService {

	@Autowired
	private RankRepository rankRepository;
	
	@Override
	public List<Rank> getAll() {
		return rankRepository.findAll();
	}

}
