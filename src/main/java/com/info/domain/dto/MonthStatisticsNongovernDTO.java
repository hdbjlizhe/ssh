package com.info.domain.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MonthStatisticsNongovernDTO {
	@NotEmpty
	@NotNull
	@Digits(integer=0,fraction=0)
	private int nongovernDevelopPlanning;
	@NotEmpty
	@NotNull
	@Digits(integer=0,fraction=0)
	private int nongovernInvestPolicy;
	@NotEmpty
	@NotNull
	@Digits(integer=0,fraction=0)
	private int nongovernAuthoritylicense;
	@NotEmpty
	@NotNull
	@Digits(integer=0,fraction=0)
	private int nongovernMarketAccess;
	@NotEmpty
	@NotNull
	@Digits(integer=0,fraction=0)
	private int nongovernInvestOpportunity;
	@NotEmpty
	@NotNull
	@Digits(integer=0,fraction=0)
	private int nongovernInvestService;
}
