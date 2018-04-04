package com.zhelee.info.controllers;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhelee.asynctasks.AsyncTask;

@RestController
public class AdminController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AsyncTask asyncTask;
	
	@RequestMapping("/syncftp")
	public String syncFtp(){
		Future<Boolean> aFuture;
		try {
			aFuture = asyncTask.syncFtpBaseFile();
			while (!aFuture.isDone()) {
				if(aFuture.isDone()){
					log.info("同步完毕");
					break;
				}			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return "sync-success";		
	}
}
