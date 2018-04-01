package com.zhelee.info.controllers;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhelee.config.AsyncTask;

@RestController
@RequestMapping("tasks")
public class AsyncTaskController {
	
	@Autowired
	private AsyncTask asyncTask;
	
	@RequestMapping("test")
	public String test() throws Exception{
		long start=System.currentTimeMillis();
		Future<Boolean> aFuture=asyncTask.sendMsg();
		Future<Boolean> bFuture=asyncTask.sendEmail();
		Future<Boolean> cFuture=asyncTask.pushAppMsg();
		
		while(!aFuture.isDone()||!bFuture.isDone()||!cFuture.isDone()) {
			if(aFuture.isDone()&&bFuture.isDone()&&cFuture.isDone()) {
				break;
			}
		}
		long end=System.currentTimeMillis();
		
		return "success:"+(end-start)+"毫秒";
	}
}
