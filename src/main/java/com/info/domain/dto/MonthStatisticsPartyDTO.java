package com.info.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class MonthStatisticsPartyDTO {
	
	private Long id;
	@NotNull
	@NotEmpty
	private Integer partyStudy;
	@NotNull
	@NotEmpty
	private Integer partyMeeting;
	@NotNull
	@NotEmpty	
	private Integer partyActivity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPartyStudy() {
		return partyStudy;
	}
	public void setPartyStudy(Integer partyStudy) {
		this.partyStudy = partyStudy;
	}
	public Integer getPartyMeeting() {
		return partyMeeting;
	}
	public void setPartyMeeting(Integer partyMeeting) {
		this.partyMeeting = partyMeeting;
	}
	public Integer getPartyActivity() {
		return partyActivity;
	}
	public void setPartyActivity(Integer partyActivity) {
		this.partyActivity = partyActivity;
	}

}
