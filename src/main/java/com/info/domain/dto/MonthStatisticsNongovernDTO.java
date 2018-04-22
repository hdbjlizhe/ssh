package com.info.domain.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MonthStatisticsNongovernDTO {

	private Long id;
	@NotEmpty
	@NotNull
	@Digits(integer=0,fraction=0)
	private Integer nongovernDevelopPlanning;
	@NotEmpty
	@NotNull
	@Digits(integer=0,fraction=0)
	private Integer nongovernInvestPolicy;
	@NotEmpty
	@NotNull
	@Digits(integer=0,fraction=0)
	private Integer nongovernAuthoritylicense;
	@NotEmpty
	@NotNull
	@Digits(integer=0,fraction=0)
	private Integer nongovernMarketAccess;
	@NotEmpty
	@NotNull
	@Digits(integer=0,fraction=0)
	private Integer nongovernInvestOpportunity;
	@NotEmpty
	@NotNull
	@Digits(integer=0,fraction=0)
	private Integer nongovernInvestService;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNongovernDevelopPlanning() {
		return nongovernDevelopPlanning;
	}
	public void setNongovernDevelopPlanning(Integer nongovernDevelopPlanning) {
		this.nongovernDevelopPlanning = nongovernDevelopPlanning;
	}
	public Integer getNongovernInvestPolicy() {
		return nongovernInvestPolicy;
	}
	public void setNongovernInvestPolicy(Integer nongovernInvestPolicy) {
		this.nongovernInvestPolicy = nongovernInvestPolicy;
	}
	public Integer getNongovernAuthoritylicense() {
		return nongovernAuthoritylicense;
	}
	public void setNongovernAuthoritylicense(Integer nongovernAuthoritylicense) {
		this.nongovernAuthoritylicense = nongovernAuthoritylicense;
	}
	public Integer getNongovernMarketAccess() {
		return nongovernMarketAccess;
	}
	public void setNongovernMarketAccess(Integer nongovernMarketAccess) {
		this.nongovernMarketAccess = nongovernMarketAccess;
	}
	public Integer getNongovernInvestOpportunity() {
		return nongovernInvestOpportunity;
	}
	public void setNongovernInvestOpportunity(Integer nongovernInvestOpportunity) {
		this.nongovernInvestOpportunity = nongovernInvestOpportunity;
	}
	public Integer getNongovernInvestService() {
		return nongovernInvestService;
	}
	public void setNongovernInvestService(Integer nongovernInvestService) {
		this.nongovernInvestService = nongovernInvestService;
	}
	
}
