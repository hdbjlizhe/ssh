package com.zhelee.config;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {

	public static final Logger logger = LoggerFactory.getLogger(AsyncTask.class);
	
	
	//发送短信
	@Async
	public Future<Boolean> sendMsg() throws Exception{
		long start=System.currentTimeMillis();
		Thread.sleep(1000);
		long end=System.currentTimeMillis();
		logger.info("发送短信任务耗时："+(end-start)+" 毫秒");
		return new AsyncResult<Boolean>(true);
	}
	
	//发送邮件
	@Async
	public Future<Boolean> sendEmail() throws Exception{
		long start=System.currentTimeMillis();
		Thread.sleep(1000);
		long end=System.currentTimeMillis();
		logger.info("发送邮件任务耗时："+(end-start)+" 毫秒");
		return new AsyncResult<Boolean>(true);
	}
	
	//App消息推送
	@Async
	public Future<Boolean> pushAppMsg() throws Exception{
		long start=System.currentTimeMillis();
		Thread.sleep(1000);
		long end=System.currentTimeMillis();
		logger.info("App推送任务耗时："+(end-start)+" 毫秒");
		return new AsyncResult<Boolean>(true);
	}
	
}
