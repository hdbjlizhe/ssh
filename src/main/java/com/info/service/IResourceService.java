package com.info.service;

import java.util.List;

import com.info.domain.entity.Resource;

public interface IResourceService {

	List<Resource> findAll();
	
	List<Resource> findByResourceString(String url);

	Resource save(Resource sysresource);
}
