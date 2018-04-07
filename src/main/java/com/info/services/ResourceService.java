package com.info.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.entities.Resource;
import com.info.repository.ResourceRepository;

@Service
public class ResourceService {
	@Autowired
	private ResourceRepository resourceRepository;
	
	public void addResource(Resource res) {
		resourceRepository.save(res);
	}

	public List<Resource> findAll() {
		return resourceRepository.findAll();
	}
	
}
