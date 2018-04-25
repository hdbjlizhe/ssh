package com.info.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personel")
public class PersonelController {
	@GetMapping("/evaluationQuarter")
	public String evaluationQuerter(Model model) {
		return "personel/evaluation-quarter";
	}
	
	@GetMapping("/evaluationMonth")
	public String evaluationMonth(Model model) {
		return "personel/evaluation-month";
	}
}
