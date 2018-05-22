package com.info.service;

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

public interface IMonthStatisticsService {

	MonthStatistics findPreOneByMonth();

	MonthStatistics save(MonthStatistics monthStatistics);

	MonthStatistics findByMonth(String rltMonth);

	MonthStatistics updateNongovern(MonthStatisticsNongovernDTO mDto);

	MonthStatistics updateMaintenance(MonthStatisticsMaintenanceDTO mDto);

	MonthStatistics updateFbaseNew(MonthStatisticsFbaseNewDTO mDto);

	MonthStatistics updateSecurity(MonthStatisticsSecurityDTO mDto);

	MonthStatistics updatePhoto(MonthStatisticsPhotoDTO mDto);

	MonthStatistics updateWebsite(MonthStatisticsWebsiteDTO mDto);

	MonthStatistics updateNews(MonthStatisticsNewsDTO mDto);

	MonthStatistics updateAffairs(MonthStatisticsAffairsDTO mDto);

	MonthStatistics updateOffice(MonthStatisticsOfficeDTO mDto);

	MonthStatistics updateParty(MonthStatisticsPartyDTO mDto);
	

}
