package com.zhelee.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class WebSchedulingTask {
	
	private final static Logger log=LoggerFactory.getLogger(WebSchedulingTask.class);
	
	//定义每天晚上进行数据库备份
	@Scheduled(cron="0 0 0 1/1 * ? ")//表达式生成地址：http://cron.qqe2.com
	public void databaseBackup() {
		log.info("数据库备份");
	}
}
