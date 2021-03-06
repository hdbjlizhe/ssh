package com.info.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
import com.info.domain.entity.DepartStatistics;
import com.info.domain.entity.Department;
import com.info.domain.entity.MonthStatistics;
import com.info.service.IDepartStatisticsService;
import com.info.service.IDepartmentService;
import com.info.service.IMonthStatisticsService;
import com.info.utils.DateAndTimeUtil;

@Controller
@RequestMapping("/daily")
public class DailyController {

	private static final Logger log = LoggerFactory.getLogger(DailyController.class);
	
	@Autowired
	private IMonthStatisticsService monthStatisticsService;

	@Autowired
	private IDepartStatisticsService departStatisticService;

	@Autowired
	private IDepartmentService departmentService;
	
	/**
	 * 获取信息服务中心的月报填报界面
	 * @param model
	 * @return
	 */
	@GetMapping("/monthReport/fill")
	public String monthReport(Model model) {
		//目标月份
		MonthStatistics monthStatistics=monthStatisticsService.findPreOneByMonth();
		model.addAttribute("statistics", monthStatistics);
		return "daily/report-monthly";
	}
	
	/**
	 * 部门统计信息的填报页面（统计每个处室每月发布的信息条数）
	 * @param model
	 * @return
	 */
	@GetMapping("/monthDepts/fill")
	public String monthDept(Model model) {
		List<DepartStatistics> departStatistics=departStatisticService.findPreOneByMonth();
		List<Department> departments=departmentService.getAll();
		if(departStatistics.isEmpty()) {
			//如果没有就新建数据
			for(Department department:departments) {
				if(department.getId()!=1) {
					DepartStatistics departStatistic=new DepartStatistics();
					departStatistic.setMonth(DateAndTimeUtil.getPreMonth(new Date()));
					departStatistic.setDepartment(department);
					departStatistics.add(departStatistic);
				}
			}
		}
		model.addAttribute("departments", departments);
		model.addAttribute("statistics",departStatistics);
		return "daily/depts-monthly";
	}
	
	/**
	 * 获取前一个月或后一个月的信息中心月报数据
	 * @param model
	 * @param inc
	 * @param currentMonth
	 * @return
	 */
	@GetMapping("/monthReport/{inc}/{currentMonth}")
	public String preNext(Model model,@PathVariable @NotNull @NotEmpty String inc,@PathVariable @NotNull @NotEmpty String currentMonth) {
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
		return "daily/report-monthly";
	}
	
	
	@GetMapping("/monthDepts/{inc}/{currentMonth}")
	public String monthDeptsPreNext(Model model,@PathVariable @NotNull @NotEmpty String inc,@PathVariable @NotNull @NotEmpty String currentMonth) {
		String rltMonth=null;
		if("pre".equals(inc.trim())) {
			rltMonth=DateAndTimeUtil.getPreMonth(currentMonth);
		}else if("next".equals(inc.trim())){
			rltMonth=DateAndTimeUtil.getNextMonth(currentMonth);
		}	
		List<Department> departments=departmentService.getAll();
		//通过月份取出数据
		List<DepartStatistics> departStatistics=departStatisticService.getByMonth(rltMonth);	
		//如果找不到就新建一个
		if(departStatistics.isEmpty()){
			for(Department department:departments) {
				if(department.getId()!=1) {
					DepartStatistics departStatistic=new DepartStatistics();
					departStatistic.setMonth(rltMonth);
					departStatistic.setDepartment(department);
					departStatistics.add(departStatistic);
				}
			}
		}
		model.addAttribute("statistics", departStatistics);
		return "daily/depts-monthly";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/monthDepts/overview")
	public String overviewDepts(Model model) {
		List<DepartStatistics> departStatistics=departStatisticService.findPreOneByMonth();
		List<Department> departments=departmentService.getAll();
		if(departStatistics.isEmpty()) {
			//如果没有就新建数据
			for(Department department:departments) {
				if(department.getId()!=1) {
					DepartStatistics departStatistic=new DepartStatistics();
					departStatistic.setMonth(DateAndTimeUtil.getPreMonth(new Date()));
					departStatistic.setDepartment(department);
					departStatistics.add(departStatistic);
				}
			}
		}
		model.addAttribute("departments", departments);
		model.addAttribute("statistics",departStatistics);
		return "daily/depts-overview";
	}
	
	/**
	 * 月报总览界面
	 * @param model
	 * @return
	 */
	@GetMapping("/monthReport/overview")
	public String overview(Model model) {
		MonthStatistics monthStatistics=monthStatisticsService.findPreOneByMonth();
		model.addAttribute("statistics", monthStatistics);
		return "daily/report-overview";
	}
	/**
	 * 获取月报总览前一个月的数据或后一个月的数据
	 * @param model
	 * @param inc
	 * @param currentMonth
	 * @return
	 */
	@GetMapping("/monthReport/overview/{inc}/{currentMonth}")
	public String overviewPreNext(Model model,@PathVariable @NotNull @NotEmpty String inc,@PathVariable @NotNull @NotEmpty String currentMonth) {
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
		return "daily/report-overview";
	}
	
	/**
	 * 
	 * @param model
	 * @param inc
	 * @param currentMonth
	 * @return
	 */
	@GetMapping("/monthDepts/overview/{inc}/{currentMonth}")
	public String monthDeptsOverviewPreNext(Model model,@PathVariable @NotNull @NotEmpty String inc,@PathVariable @NotNull @NotEmpty String currentMonth) {
		String rltMonth=null;
		if("pre".equals(inc.trim())) {
			rltMonth=DateAndTimeUtil.getPreMonth(currentMonth);
		}else if("next".equals(inc.trim())){
			rltMonth=DateAndTimeUtil.getNextMonth(currentMonth);
		}	
		List<Department> departments=departmentService.getAll();
		//通过月份取出数据
		List<DepartStatistics> departStatistics=departStatisticService.getByMonth(rltMonth);	
		//如果找不到就新建一个
		if(departStatistics.isEmpty()){
			for(Department department:departments) {
				if(department.getId()!=1) {
					DepartStatistics departStatistic=new DepartStatistics();
					departStatistic.setMonth(rltMonth);
					departStatistic.setDepartment(department);
					departStatistics.add(departStatistic);
				}
			}
		}
		model.addAttribute("statistics", departStatistics);
		return "daily/depts-overview";
	}
	
		
	/*************************************************************************************************************
	 * Ajax请求
	 * @return boolean型
	 *************************************************************************************************************/
	@ResponseBody
	@PostMapping("/monthReport/party")
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
	@PostMapping("/monthReport/office")
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
	@PostMapping("/monthReport/affairs")
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
	@PostMapping("/monthReport/news")
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
	@PostMapping("/monthReport/website")
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
	@PostMapping("/monthReport/nongovern")
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
	@PostMapping("/monthReport/maintenance")
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
	@PostMapping("/monthReport/fbase")
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
	@PostMapping("/monthReport/security")
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
	@PostMapping("/monthReport/photo")
	public boolean photo(MonthStatisticsPhotoDTO mDto, BindingResult result) {
		if (result.hasErrors()) {
			log.info(result.getFieldError().toString());
			return false;
		}
		monthStatisticsService.updatePhoto(mDto);
		return true;
	}
}
