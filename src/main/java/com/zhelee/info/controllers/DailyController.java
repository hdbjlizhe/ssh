package com.zhelee.info.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zhelee.info.entities.Department;
import com.zhelee.info.services.DepartmentService;

@Controller
public class DailyController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/monthly-report")
	public String monthlyReport(Model model) {
		List<Department> departments=new ArrayList<Department>();
		departments=departmentService.findAll();
		model.addAttribute("departments",departments);
		return "daily/monthly-report";
	}
}
