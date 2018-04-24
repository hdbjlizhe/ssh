package com.info.controllers;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.domain.MonthStatistics;
import com.info.domain.dto.MonthStatisticsAffairsDTO;
import com.info.domain.dto.MonthStatisticsFbaseNewDTO;
import com.info.domain.dto.MonthStatisticsMaintenanceDTO;
import com.info.domain.dto.MonthStatisticsNewsDTO;
import com.info.domain.dto.MonthStatisticsNongovernDTO;
import com.info.domain.dto.MonthStatisticsOfficeDTO;
import com.info.domain.dto.MonthStatisticsPartyDTO;
import com.info.domain.dto.MonthStatisticsPhotoDTO;
import com.info.domain.dto.MonthStatisticsSecurityDTO;
import com.info.domain.dto.MonthStatisticsWebsiteDTO;
import com.info.service.impl.MonthStatisticsService;
import com.info.utils.DateAndTimeUtil;

@Controller
@RequestMapping("/monthReport")
public class DailyController {

	private static final Logger log = LoggerFactory.getLogger(DailyController.class);
	
	@Autowired
	private MonthStatisticsService monthStatisticsService;

	@GetMapping("/")
	public String monthReport(Model model) {
		//目标月份
		String resultMonth=null;
		DateTime dt= new DateTime();
		String FORMATE_DATE = "yyyy-MM";
		resultMonth=DateAndTimeUtil.getPreMonth(dt.toString(FORMATE_DATE));	
		
		//通过月份取出数据
		MonthStatistics monthStatistics=monthStatisticsService.findByMonth(resultMonth);
		//如果找不到就新建一个
		if(monthStatistics==null){
			monthStatistics=new MonthStatistics();
			monthStatistics.setMonth(resultMonth);
			monthStatistics=monthStatisticsService.save(monthStatistics);
		}
		model.addAttribute("statistics", monthStatistics);
		return "/daily/monthly-report";
	}
	
	//前一个月份的数据
	@GetMapping("/{inc}/{currentMonth}")
	public String pre(Model model,@PathVariable @NotNull @NotEmpty String inc,@PathVariable @NotNull @NotEmpty String currentMonth) {
		String rltMonth=null;
		if("pre".equals(inc.trim())) {
			rltMonth=DateAndTimeUtil.getPreMonth(currentMonth);
		}else if("next".equals(inc.trim())){
			rltMonth=DateAndTimeUtil.getNextMonth(currentMonth);
		}
		
		//通过月份取出数据
		MonthStatistics monthStatistics=monthStatisticsService.findByMonth(rltMonth);
		//如果找不到就新建一个
		if(monthStatistics==null){
			monthStatistics=new MonthStatistics();
			monthStatistics.setMonth(rltMonth);
			monthStatistics=monthStatisticsService.save(monthStatistics);
		}
		model.addAttribute("statistics", monthStatistics);
		return "/daily/monthly-report";
	}
	
	/*************************************************************************************************************
	 * Ajax请求
	 * @return boolean型
	 *************************************************************************************************************/
	@ResponseBody
	@PostMapping("/party")
	public boolean party(MonthStatisticsPartyDTO mDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			log.info(result.getFieldError().toString());
			model.addAttribute("message", result.getFieldError());
			return false;
		}
		monthStatisticsService.updateParty(mDto);
		return true;
	}

	@ResponseBody
	@PostMapping("/office")
	public boolean office(MonthStatisticsOfficeDTO mDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			log.info(result.getFieldError().toString());
			model.addAttribute("message", result.getFieldError());
			return false;
		}
		monthStatisticsService.updateOffice(mDto);
		return true;
	}

	@ResponseBody
	@PostMapping("/affairs")
	public boolean affairs(MonthStatisticsAffairsDTO mDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			log.info(result.getFieldError().toString());
			model.addAttribute("message", result.getFieldError());
			return false;
		}
		monthStatisticsService.updateAffairs(mDto);
		return true;
	}

	@ResponseBody
	@PostMapping("/news")
	public boolean news(MonthStatisticsNewsDTO mDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			log.info(result.getFieldError().toString());
			model.addAttribute("message", result.getFieldError());
			return false;
		}
		monthStatisticsService.updateNews(mDto);
		return true;
	}

	@ResponseBody
	@PostMapping("/website")
	public boolean website(MonthStatisticsWebsiteDTO mDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			log.info(result.getFieldError().toString());
			model.addAttribute("message", result.getFieldError());
			return false;
		}
		monthStatisticsService.updateWebsite(mDto);
		return true;
	}

	@ResponseBody
	@PostMapping("/nongovern")
	public boolean nongovern(MonthStatisticsNongovernDTO mDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			log.info(result.getFieldError().toString());
			model.addAttribute("message", result.getFieldError());
			return false;
		}
		monthStatisticsService.updateNongovern(mDto);
		return true;
	}

	@ResponseBody
	@PostMapping("/maintenance")
	public boolean mainenance(MonthStatisticsMaintenanceDTO mDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			log.info(result.getFieldError().toString());
			model.addAttribute("message", result.getFieldError());
			return false;
		}
		monthStatisticsService.updateMaintenance(mDto);
		return true;
	}

	@ResponseBody
	@PostMapping("/fbase")
	public boolean fbase(MonthStatisticsFbaseNewDTO mDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			log.info(result.getFieldError().toString());
			model.addAttribute("message", result.getFieldError());
			return false;
		}
		monthStatisticsService.updateFbaseNew(mDto);
		return true;
	}

	@ResponseBody
	@PostMapping("/security")
	public boolean security(MonthStatisticsSecurityDTO mDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			log.info(result.getFieldError().toString());
			model.addAttribute("message", result.getFieldError());
			return false;
		}
		monthStatisticsService.updateSecurity(mDto);
		return true;
	}

	@ResponseBody
	@PostMapping("/photo")
	public boolean photo(MonthStatisticsPhotoDTO mDto, BindingResult result) {
		if (result.hasErrors()) {
			log.info(result.getFieldError().toString());
			return false;
		}
		monthStatisticsService.updatePhoto(mDto);
		return true;
	}
}
