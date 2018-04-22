package com.info.domain.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MonthStatisticsWebsiteDTO {

	private Long id;
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private Integer websiteProfile;//
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private Integer websiteInvestBeijing;//
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private Integer websiteInteraction;//
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private Integer websiteMatters;//
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private Integer websiteParty;//
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private Integer websiteInfo;//
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getWebsiteProfile() {
		return websiteProfile;
	}
	public void setWebsiteProfile(Integer websiteProfile) {
		this.websiteProfile = websiteProfile;
	}
	public Integer getWebsiteInvestBeijing() {
		return websiteInvestBeijing;
	}
	public void setWebsiteInvestBeijing(Integer websiteInvestBeijing) {
		this.websiteInvestBeijing = websiteInvestBeijing;
	}
	public Integer getWebsiteInteraction() {
		return websiteInteraction;
	}
	public void setWebsiteInteraction(Integer websiteInteraction) {
		this.websiteInteraction = websiteInteraction;
	}
	public Integer getWebsiteMatters() {
		return websiteMatters;
	}
	public void setWebsiteMatters(Integer websiteMatters) {
		this.websiteMatters = websiteMatters;
	}
	public Integer getWebsiteParty() {
		return websiteParty;
	}
	public void setWebsiteParty(Integer websiteParty) {
		this.websiteParty = websiteParty;
	}
	public Integer getWebsiteInfo() {
		return websiteInfo;
	}
	public void setWebsiteInfo(Integer websiteInfo) {
		this.websiteInfo = websiteInfo;
	}

}
