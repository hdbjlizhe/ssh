package com.info.controllers;

import org.joda.time.DateTime;
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
import com.info.service.impl.MonthStatisticsService;

@Controller
public class DailyController {

	private static final Logger log = LoggerFactory.getLogger(DailyController.class);
	
	@Autowired
	private MonthStatisticsService monthStatisticsService;

	@GetMapping("/monthly-report")
	public String monthlyReport(Model model) {
		String FORMATE_DATE = "yyyyMM";
		DateTime dt= new DateTime();
		String month=dt.toString(FORMATE_DATE);
		MonthStatistics monthStatistics=monthStatisticsService.findByMonth(month);
		//如果找不到就新建一个
		if(monthStatistics==null){
			monthStatistics=new MonthStatistics();
			monthStatistics.setMonth(month);
			monthStatistics=monthStatisticsService.save(monthStatistics);
		}
		model.addAttribute("statistics", monthStatistics);
		return "daily/monthly-report";
	}
	
	@PostMapping("/monthly-report")
	public String monthReport(Model model,String month) {
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
		//判断Id是否为空，如果为空则新增
		if(mDto.getId()==null) {
			MonthStatistics monthStatistics=new MonthStatistics();
			monthStatistics.setPartyActivity(mDto.getPartyActivity());
			monthStatistics.setPartyMeeting(mDto.getPartyMeeting());
			monthStatistics.setPartyStudy(mDto.getPartyStudy());
			monthStatisticsService.save(monthStatistics);
			
			return true;
		}else {
			//id不为空，则更新
			monthStatisticsService.updateParty(mDto);
			return true;
		}
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
