package com.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.entity.Resource;
import com.info.domain.repository.ResourceRepository;

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

	public List<Resource> findByUri(String url) {
		return resourceRepository.findByUri(url);
	}

	public Resource save(Resource resource) {
		return resourceRepository.save(resource);
	}

	public List<Resource> findByResourceString(String url) {
		return resourceRepository.findByUri(url);
	}
	
}
