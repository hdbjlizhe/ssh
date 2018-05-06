package com.info.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/decorators")
public class DecoratorController {
	
	@GetMapping("/default")
	public String index() {
		return "/decorators/decorator-default";
	}
	@GetMapping("/about")
	public String about() {
		return "/decorators/decorator-about";
	}
	@GetMapping("/party")
	public String party() {
		return "/decorators/decorator-party";
	}
	@GetMapping("/office")
	public String office() {
		return "/decorators/decorator-office";
	}
	@GetMapping("/cms")
	public String cms() {
		return "/decorators/decorator-cms";
	}
	@GetMapping("/daily")
	public String daily() {
		return "/decorators/decorator-daily";
	}
	@GetMapping("/report")
	public String report() {
		return "/decorators/decorator-report";
	}
	@GetMapping("/personel")
	public String personel() {
		return "/decorators/decorator-personel";
	}
	@GetMapping("/userdetails")
	public String userDetails() {
		return "/decorators/decorator-userdetails";
	}
	@GetMapping("/lmr")//左中右结构
	public String lmr() {
		return "/decorators/decorator-lmr";
	}
}
