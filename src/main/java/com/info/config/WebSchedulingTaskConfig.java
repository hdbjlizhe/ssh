package com.info.config;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import com.info.domain.FtpBaseFile;
import com.info.service.impl.FtpBaseFileService;
import com.info.utils.FtpBaseFileUtil;
/**
 * 
 * 定时任务
 * 1.数据库备份任务，保证安全
 * 2.FTP资料库同步任务
 * @author Administrator
 *
 */
public class WebSchedulingTaskConfig {
	
	private static final Logger log=LoggerFactory.getLogger(WebSchedulingTaskConfig.class);
	
	//定义每天晚上0点进行数据库备份
	@Scheduled(cron="0 0 0 * * ? *")//表达式生成地址：http://cron.qqe2.com
	public void databaseBackup() {
		log.info("数据库备份");
	}
	
	
	//同步FTP资料库的文件，每天晚上0点进行同步
	@Autowired
	private FtpBaseFileService ftpBaseFileService;	
	@Scheduled(cron="0 0 0 * * ? *")
	@Async
	public void syncFtpBase() throws UnsupportedEncodingException, IOException{
		FtpBaseFileUtil ftpBaseFileUtil=new FtpBaseFileUtil(false);
		//准备要存储的数据
		List<FtpBaseFile> ftpBaseFiles=ftpBaseFileUtil.listAll();
		//清空数据库表ftpbasefile
		ftpBaseFileService.deleteAll();
		//存储数据库表ftpbasefile
		ftpBaseFileService.addAll(ftpBaseFiles);
		log.info("同步FTP资料库完成");
	}
	
}
