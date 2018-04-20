package com.info.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MonthStatisticsPartyDTO {
	@NotNull
	@NotEmpty
	private int partyStudy;
	@NotNull
	@NotEmpty
	private int partyMeeting;
	@NotNull
	@NotEmpty
	private int partyActivity;
	public int getPartyStudy() {
		return partyStudy;
	}
	public void setPartyStudy(int partyStudy) {
		this.partyStudy = partyStudy;
	}
	public int getPartyMeeting() {
		return partyMeeting;
	}
	public void setPartyMeeting(int partyMeeting) {
		this.partyMeeting = partyMeeting;
	}
	public int getPartyActivity() {
		return partyActivity;
	}
	public void setPartyActivity(int partyActivity) {
		this.partyActivity = partyActivity;
	}
	
}
