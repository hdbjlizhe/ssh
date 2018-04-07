package com.zhelee.info.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DecoratorController {
	
	@GetMapping("/decorators/default")
	public String index() {
		return "/decorators/default";
	}
	@GetMapping("/decorators/about")
	public String about() {
		return "/decorators/about";
	}
}
