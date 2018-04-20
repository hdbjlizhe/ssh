package com.info.controllers;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.info.asyntasks.AsyncTask;

@Controller
public class AdminController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AsyncTask asyncTask;
	
	@GetMapping("/admin")
	public String Admin() {
		return "/admin/admin";
	}
	
	@RequestMapping("/syncftp")
	public String syncFtp(){
		Future<Boolean> aFuture;
		try {
			aFuture = asyncTask.syncFtpBase();
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
