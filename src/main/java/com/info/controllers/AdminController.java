package com.info.controllers;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.info.asyntasks.AsyncTask;
import com.info.domain.entity.Resource;
import com.info.service.IResourceService;

import java.util.List;

@Controller
public class AdminController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AsyncTask asyncTask;
	
	@Autowired
	private IResourceService resourceService;
	
	/**
	 * 获取后台管理员页面
	 * @param model
	 * @return
	 */
	@GetMapping("/admin")
	public String Admin(Model model) {
		List<Resource> resources=resourceService.findAll();
		model.addAttribute("resources", resources);
		return "admin/admin";
	}
	
	/**
	 * 
	 * @return
	 */
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
