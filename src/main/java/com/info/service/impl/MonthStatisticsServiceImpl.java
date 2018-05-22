package com.info.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.info.domain.entity.MonthStatistics;
import com.info.domain.repository.MonthStatisticsRepository;
import com.info.service.IMonthStatisticsService;
import com.info.utils.DateAndTimeUtil;

@Service
public class MonthStatisticsServiceImpl implements IMonthStatisticsService {
	@Autowired
	private MonthStatisticsRepository monthStatisticsRepository;
	
	public MonthStatistics save(MonthStatistics monthStatistics) {
		return monthStatisticsRepository.save(monthStatistics);
	}

	public MonthStatistics findByMonth(String month) {
		return monthStatisticsRepository.findByMonth(month);
	}
	
	/**
	 * 获取当前月份的前一个月份数据
	 * @return
	 */
	public MonthStatistics findPreOneByMonth() {
		//目标月份
		String resultMonth=null;
		DateTime dt= new DateTime();
		String FORMATE_DATE = "yyyy-MM";
		resultMonth=DateAndTimeUtil.getPreMonth(dt.toString(FORMATE_DATE));	
		//通过月份取出数据
		MonthStatistics monthStatistics=monthStatisticsRepository.findByMonth(resultMonth);
		//如果找不到就新建一个
		if(monthStatistics==null){
			monthStatistics=new MonthStatistics();
			monthStatistics.setMonth(resultMonth);
			monthStatistics=monthStatisticsRepository.save(monthStatistics);
		}
		return monthStatistics;
	}
	
	/**
	 * 获取给定月份的前一个月份的“信息服务中心工作数据”
	 * @return
	 */
	public MonthStatistics findPreOneByMonth(String month) {
		//目标月份
		String resultMonth=null;
		DateTime dt= new DateTime();
		String FORMATE_DATE = "yyyy-MM";
		resultMonth=DateAndTimeUtil.getPreMonth(dt.toString(FORMATE_DATE));	
		//通过月份取出数据
		MonthStatistics monthStatistics=monthStatisticsRepository.findByMonth(resultMonth);
		//如果找不到就新建一个
		if(monthStatistics==null){
			monthStatistics=new MonthStatistics();
			monthStatistics.setMonth(resultMonth);
			monthStatistics=monthStatisticsRepository.save(monthStatistics);
		}
		return monthStatistics;
	}
			
	/**
	 * 更新“信息服务中心统计数据”中党务相关的数据
	 * @param dto
	 * @return
	 */
	public MonthStatistics updateParty(MonthStatisticsPartyDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setPartyStudy(dto.getPartyStudy());
		monthStatistics.setPartyMeeting(dto.getPartyMeeting());
		monthStatistics.setPartyActivity(dto.getPartyActivity());
		return monthStatisticsRepository.save(monthStatistics);
	}
	
	/**
	 * 更新“信息服务中心统计数据”中公文往来相关的数据
	 * @param dto
	 * @return
	 */
	public MonthStatistics updateOffice(MonthStatisticsOfficeDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setDocDepart(dto.getDocDepart());
		monthStatistics.setDocOffice(dto.getDocOffice());
		return monthStatisticsRepository.save(monthStatistics);
	}
	
	/**
	 * 更新“信息服务中心统计数据”中例会Affairs
	 * @param dto
	 * @return
	 */
	public MonthStatistics updateAffairs(MonthStatisticsAffairsDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setAffairs(dto.getAffairs());
		return monthStatisticsRepository.save(monthStatistics);
	}
	
	/**
	 * 更新“信息服务中心统计数据”中news
	 * @param dto
	 * @return
	 */
	public MonthStatistics updateNews(MonthStatisticsNewsDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setWebchatOriginal(dto.getWebchatOriginal());
		monthStatistics.setWebchatTranspond(dto.getWebchatTranspond());
		monthStatistics.setWeiboOriginal(dto.getWeiboOriginal());
		monthStatistics.setWeiboTranspond(dto.getWeiboTranspond());
		monthStatistics.setToutiaoOriginal(dto.getToutiaoOriginal());
		monthStatistics.setToutiaoTranspond(dto.getToutiaoTranspond());
		monthStatistics.setNewsBoard(dto.getNewsBoard());
		monthStatistics.setNewsWebsite(dto.getNewsWebsite());
		return monthStatisticsRepository.save(monthStatistics);
	}
	
	/**
	 * 更新“信息服务中心统计数据”中Website
	 * @param dto
	 * @return
	 */
	public MonthStatistics updateWebsite(MonthStatisticsWebsiteDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setWebsiteProfile(dto.getWebsiteProfile());
		monthStatistics.setWebsiteInvestBeijing(dto.getWebsiteInvestBeijing());
		monthStatistics.setWebsiteInteraction(dto.getWebsiteInteraction());
		monthStatistics.setWebsiteMatters(dto.getWebsiteMatters());
		monthStatistics.setWebsiteParty(dto.getWebsiteParty());
		monthStatistics.setWebsiteInfo(dto.getWebsiteInfo());
		return monthStatisticsRepository.save(monthStatistics);
	}
	
	/**
	 * 更新“信息服务中心统计数据”中民投nongovern
	 * @param dto
	 * @return
	 */
	public MonthStatistics updateNongovern(MonthStatisticsNongovernDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setNongovernAuthoritylicense(dto.getNongovernAuthoritylicense());
		monthStatistics.setNongovernDevelopPlanning(dto.getNongovernDevelopPlanning());
		monthStatistics.setNongovernInvestOpportunity(dto.getNongovernInvestOpportunity());
		monthStatistics.setNongovernInvestPolicy(dto.getNongovernInvestPolicy());
		monthStatistics.setNongovernInvestService(dto.getNongovernInvestService());
		monthStatistics.setNongovernMarketAccess(dto.getNongovernMarketAccess());
		return monthStatisticsRepository.save(monthStatistics);
	}
	
	/**
	 * 更新“信息服务中心统计数据”中maintenance
	 * @param dto
	 * @return
	 */
	public MonthStatistics updateMaintenance(MonthStatisticsMaintenanceDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setMaintenanceHardware(dto.getMaintenanceHardware());
		monthStatistics.setMaintenanceSoftware(dto.getMaintenanceSoftware());
		return monthStatisticsRepository.save(monthStatistics);
	}
	
	/**
	 * 更新“信息服务中心统计数据”中fbaseNew
	 * @param dto
	 * @return
	 */
	public MonthStatistics updateFbaseNew(MonthStatisticsFbaseNewDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setFbaseNew(dto.getFbaseNew());
		return monthStatisticsRepository.save(monthStatistics);
	}
	
	/**
	 * 更新“信息服务中心统计数据”中Security
	 * @param dto
	 * @return
	 */
	public MonthStatistics updateSecurity(MonthStatisticsSecurityDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setSecurityAttackBlock(dto.getSecurityAttackBlock());
		monthStatistics.setSecurityBugNum(dto.getSecurityBugNum());
		monthStatistics.setSecurityBugScan(dto.getSecurityBugScan());
		monthStatistics.setSecurityGlobalTrouble(dto.getSecurityGlobalTrouble());
		monthStatistics.setSecuritySafetyMessage(dto.getSecuritySafetyMessage());
		monthStatistics.setSecuritySystemReinforce(dto.getSecuritySystemReinforce());
		monthStatistics.setSecurityWebsiteTrouble(dto.getSecurityWebsiteTrouble());
		return monthStatisticsRepository.save(monthStatistics);
	}
	
	/**
	 * 更新“信息服务中心统计数据”中photo
	 * @param dto
	 * @return
	 */
	public MonthStatistics updatePhoto(MonthStatisticsPhotoDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setPhotoActivity(dto.getPhotoActivity());
		monthStatistics.setPhotoImgNum(dto.getPhotoImgNum());
		monthStatistics.setPhotoMeeting(dto.getPhotoMeeting());
		monthStatistics.setPhotoVideoNum(dto.getPhotoVideoNum());
		return monthStatisticsRepository.save(monthStatistics);
	}
	
}
