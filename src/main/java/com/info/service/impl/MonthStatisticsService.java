package com.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.info.domain.repository.MonthStatisticsRepository;

@Service
public class MonthStatisticsService {
	@Autowired
	private MonthStatisticsRepository monthStatisticsRepository;
	
	public MonthStatistics save(MonthStatistics monthStatistics) {
		return monthStatisticsRepository.save(monthStatistics);
	}

	public MonthStatistics findByMonth(String month) {
		return monthStatisticsRepository.findByMonth(month);
	}
	//更新party
	public void updateParty(MonthStatisticsPartyDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setPartyStudy(dto.getPartyStudy());
		monthStatistics.setPartyMeeting(dto.getPartyMeeting());
		monthStatistics.setPartyActivity(dto.getPartyActivity());
		monthStatisticsRepository.save(monthStatistics);
	}
	//更新OfficeDoc
	public void updateOffice(MonthStatisticsOfficeDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setDocDepart(dto.getDocDepart());
		monthStatistics.setDocOffice(dto.getDocOffice());
		monthStatisticsRepository.save(monthStatistics);
	}
	//更新例会Affairs
	public void updateAffairs(MonthStatisticsAffairsDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setAffairs(dto.getAffairs());
		monthStatisticsRepository.save(monthStatistics);
	}
	//更新news
	public void updateNews(MonthStatisticsNewsDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setWebchatOriginal(dto.getWebchatOriginal());
		monthStatistics.setWebchatTranspond(dto.getWebchatTranspond());
		monthStatistics.setWeiboOriginal(dto.getWeiboOriginal());
		monthStatistics.setWeiboTranspond(dto.getWeiboTranspond());
		monthStatistics.setToutiaoOriginal(dto.getToutiaoOriginal());
		monthStatistics.setToutiaoTranspond(dto.getToutiaoTranspond());
		monthStatistics.setNewsBoard(dto.getNewsBoard());
		monthStatistics.setNewsWebsite(dto.getNewsWebsite());
		monthStatisticsRepository.save(monthStatistics);
	}
	//更新Website
	public void updateWebsite(MonthStatisticsWebsiteDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setWebsiteProfile(dto.getWebsiteProfile());
		monthStatistics.setWebsiteInvestBeijing(dto.getWebsiteInvestBeijing());
		monthStatistics.setWebsiteInteraction(dto.getWebsiteInteraction());
		monthStatistics.setWebsiteMatters(dto.getWebsiteMatters());
		monthStatistics.setWebsiteParty(dto.getWebsiteParty());
		monthStatistics.setWebsiteInfo(dto.getWebsiteInfo());
		monthStatisticsRepository.save(monthStatistics);
	}
	//更新民投nongovern
	public void updateNongovern(MonthStatisticsNongovernDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setNongovernAuthoritylicense(dto.getNongovernAuthoritylicense());
		monthStatistics.setNongovernDevelopPlanning(dto.getNongovernDevelopPlanning());
		monthStatistics.setNongovernInvestOpportunity(dto.getNongovernInvestOpportunity());
		monthStatistics.setNongovernInvestPolicy(dto.getNongovernInvestPolicy());
		monthStatistics.setNongovernInvestService(dto.getNongovernInvestService());
		monthStatistics.setNongovernMarketAccess(dto.getNongovernMarketAccess());
		monthStatisticsRepository.save(monthStatistics);
	}
	//更新maintenance
	public void updateMaintenance(MonthStatisticsMaintenanceDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setMaintenanceHardware(dto.getMaintenanceHardware());
		monthStatistics.setMaintenanceSoftware(dto.getMaintenanceSoftware());
		monthStatisticsRepository.save(monthStatistics);
	}
	//更新fbaseNew
	public void updateFbaseNew(MonthStatisticsFbaseNewDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setFbaseNew(dto.getFbaseNew());
		monthStatisticsRepository.save(monthStatistics);
	}
	//更新Security
	public void updateSecurity(MonthStatisticsSecurityDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setSecurityAttackBlock(dto.getSecurityAttackBlock());
		monthStatistics.setSecurityBugNum(dto.getSecurityBugNum());
		monthStatistics.setSecurityBugScan(dto.getSecurityBugScan());
		monthStatistics.setSecurityGlobalTrouble(dto.getSecurityGlobalTrouble());
		monthStatistics.setSecuritySafetyMessage(dto.getSecuritySafetyMessage());
		monthStatistics.setSecuritySystemReinforce(dto.getSecuritySystemReinforce());
		monthStatistics.setSecurityWebsiteTrouble(dto.getSecurityWebsiteTrouble());
		monthStatisticsRepository.save(monthStatistics);
	}
	//更新photo
	public void updatePhoto(MonthStatisticsPhotoDTO dto) {
		MonthStatistics monthStatistics=monthStatisticsRepository.getOne(dto.getId());
		monthStatistics.setPhotoActivity(dto.getPhotoActivity());
		monthStatistics.setPhotoImgNum(dto.getPhotoImgNum());
		monthStatistics.setPhotoMeeting(dto.getPhotoMeeting());
		monthStatistics.setPhotoVideoNum(dto.getPhotoVideoNum());
		monthStatisticsRepository.save(monthStatistics);
	}
	
}
