package com.info.service;

import java.util.List;

import com.info.domain.entity.FtpBaseFile;

public interface IFtpBaseFileService {

	void deleteAll();

	void addAll(List<FtpBaseFile> ftpBaseFiles);

}
