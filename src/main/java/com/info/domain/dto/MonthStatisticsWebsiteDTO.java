package com.info.domain.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MonthStatisticsWebsiteDTO {
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private int websiteProfile;//
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private int websiteInvestBeijing;//
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private int websiteInteraction;//
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private int websiteMatters;//
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private int websiteParty;//
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private int websiteInfo;//
	
	public int getWebsiteProfile() {
		return websiteProfile;
	}
	public void setWebsiteProfile(int websiteProfile) {
		this.websiteProfile = websiteProfile;
	}
	public int getWebsiteInvestBeijing() {
		return websiteInvestBeijing;
	}
	public void setWebsiteInvestBeijing(int websiteInvestBeijing) {
		this.websiteInvestBeijing = websiteInvestBeijing;
	}
	public int getWebsiteInteraction() {
		return websiteInteraction;
	}
	public void setWebsiteInteraction(int websiteInteraction) {
		this.websiteInteraction = websiteInteraction;
	}
	public int getWebsiteMatters() {
		return websiteMatters;
	}
	public void setWebsiteMatters(int websiteMatters) {
		this.websiteMatters = websiteMatters;
	}
	public int getWebsiteParty() {
		return websiteParty;
	}
	public void setWebsiteParty(int websiteParty) {
		this.websiteParty = websiteParty;
	}
	public int getWebsiteInfo() {
		return websiteInfo;
	}
	public void setWebsiteInfo(int websiteInfo) {
		this.websiteInfo = websiteInfo;
	}

}
