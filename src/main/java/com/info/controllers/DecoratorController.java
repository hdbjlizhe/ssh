package com.info.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DecoratorController {
	
	@GetMapping("/decorators/default")
	public String index() {
		return "/decorators/decorator-default";
	}
	@GetMapping("/decorators/about")
	public String about() {
		return "/decorators/decorator-about";
	}
	@GetMapping("/decorators/party")
	public String party() {
		return "/decorators/decorator-party";
	}
	@GetMapping("/decorators/office")
	public String office() {
		return "/decorators/decorator-office";
	}
	@GetMapping("/decorators/cms")
	public String cms() {
		return "/decorators/decorator-cms";
	}
	@GetMapping("/decorators/report")
	public String report() {
		return "/decorators/decorator-report";
	}
	@GetMapping("/decorators/personel")
	public String personel() {
		return "/decorators/decorator-personel";
	}
	
}
