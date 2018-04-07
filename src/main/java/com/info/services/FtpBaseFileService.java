package com.info.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.FtpBaseFile;
import com.info.repository.FtpBaseFileRepository;

@Service
public class FtpBaseFileService {

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
