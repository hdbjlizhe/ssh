package com.info.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DecoratorController {
	
	@RequestMapping("/decorators/default")
	public String indexGet() {
		return "/decorators/default";
	}
	@GetMapping("/decorators/about")
	public String about() {
		return "/decorators/about";
	}
	@GetMapping("/decorators/party")
	public String party() {
		return "/decorators/party";
	}
	@GetMapping("/decorators/office")
	public String office() {
		return "/decorators/office";
	}
	@GetMapping("/decorators/cms")
	public String cms() {
		return "/decorators/cms";
	}
	@GetMapping("/decorators/report")
	public String report() {
		return "/decorators/report";
	}
	
}
