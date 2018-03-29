package com.zhelee.info.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfficeController {
	
	@GetMapping(value="/monthly-report")
	public String monthlyReport() {
		return "monthly-report";
	}
}	
