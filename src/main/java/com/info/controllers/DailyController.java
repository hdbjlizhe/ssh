package com.info.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.info.domain.MonthStatistics;
import com.info.domain.dto.MonthStatisticsOfficeDTO;
import com.info.domain.dto.MonthStatisticsPartyDTO;
import com.info.domain.entity.Department;
import com.info.service.impl.DepartmentService;
import com.info.service.impl.MonthStatisticsService;

@Controller
public class DailyController {

	private static final Logger log = LoggerFactory.getLogger(DailyController.class);

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private MonthStatisticsService monthStatisticsService;

	@GetMapping("/monthly-report")
	public String monthlyReport(Model model,String month) {
		MonthStatistics monthStatistics=monthStatisticsService.findByMonth(month);
		model.addAttribute("statistics", monthStatistics);
		return "daily/monthly-report";
	}

	/**
	 * 以下均为AJAX请求
	 * 
	 * @return
	 */
	@PostMapping("/monthReport/party")
	public boolean party(MonthStatisticsPartyDTO mDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			log.info(result.getFieldError().toString());
			model.addAttribute("message", result.getFieldError());
			return false;
		}
		
		return true;
	}

	@PostMapping("/monthReport/office")
	public boolean office(MonthStatisticsOfficeDTO mDto) {
		return true;
	}

	@PostMapping("/monthReport/affairs")
	public boolean affairs() {
		return true;
	}

	@PostMapping("/monthReport/news")
	public boolean news() {
		return true;
	}

	@PostMapping("/monthReport/website")
	public boolean website() {
		return true;
	}

	@PostMapping("/monthReport/nongovern")
	public boolean nongovern() {
		return true;
	}

	@PostMapping("/monthReport/mainenance")
	public boolean mainenance() {
		return true;
	}

	@PostMapping("/monthReport/fbase")
	public boolean fbase() {
		return true;
	}

	@PostMapping("/monthReport/security")
	public boolean security() {
		return true;
	}

	@PostMapping("/monthReport/photo")
	public boolean photo() {
		return true;
	}

}
