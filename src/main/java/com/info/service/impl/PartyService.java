package com.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.entity.Party;
import com.info.domain.repository.PartyRepository;
import com.info.service.IPartyService;
@Service
public class PartyService implements IPartyService {

	@Autowired
	private PartyRepository partyRepository;
	
	@Override
	public List<Party> getAll() {
		return partyRepository.findAll();
	}

}
