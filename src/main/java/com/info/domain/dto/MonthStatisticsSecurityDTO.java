package com.info.domain.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MonthStatisticsSecurityDTO {
	
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private int securityAttackBlock;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private int securitySystemReinforce;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private int securitySafetyMessage;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private int securityBugScan;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private int securityBugNum;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private int securityWebsiteTrouble;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private int securityGlobalTrouble;
}
