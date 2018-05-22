package com.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.entity.FtpBaseFile;
import com.info.domain.repository.FtpBaseFileRepository;
import com.info.service.IFtpBaseFileService;

@Service
public class FtpBaseFileServiceImpl implements IFtpBaseFileService {

	@Autowired
	private FtpBaseFileRepository ftpBaseFileRepository;
		
	//清空数据表
	public void deleteAll(){		
		ftpBaseFileRepository.deleteAll();		
	}
	//增加数据
	public void addAll(List<FtpBaseFile> ftpBaseFiles){
		ftpBaseFileRepository.saveAll(ftpBaseFiles);
	}
		
}
