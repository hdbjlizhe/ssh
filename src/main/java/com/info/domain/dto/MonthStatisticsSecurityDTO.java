package com.info.domain.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MonthStatisticsSecurityDTO {
	
	private Long id;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private Integer securityAttackBlock;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private Integer securitySystemReinforce;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private Integer securitySafetyMessage;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private Integer securityBugScan;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private Integer securityBugNum;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private Integer securityWebsiteTrouble;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private Integer securityGlobalTrouble;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getSecurityAttackBlock() {
		return securityAttackBlock;
	}
	public void setSecurityAttackBlock(Integer securityAttackBlock) {
		this.securityAttackBlock = securityAttackBlock;
	}
	public Integer getSecuritySystemReinforce() {
		return securitySystemReinforce;
	}
	public void setSecuritySystemReinforce(Integer securitySystemReinforce) {
		this.securitySystemReinforce = securitySystemReinforce;
	}
	public Integer getSecuritySafetyMessage() {
		return securitySafetyMessage;
	}
	public void setSecuritySafetyMessage(Integer securitySafetyMessage) {
		this.securitySafetyMessage = securitySafetyMessage;
	}
	public Integer getSecurityBugScan() {
		return securityBugScan;
	}
	public void setSecurityBugScan(Integer securityBugScan) {
		this.securityBugScan = securityBugScan;
	}
	public Integer getSecurityBugNum() {
		return securityBugNum;
	}
	public void setSecurityBugNum(Integer securityBugNum) {
		this.securityBugNum = securityBugNum;
	}
	public Integer getSecurityWebsiteTrouble() {
		return securityWebsiteTrouble;
	}
	public void setSecurityWebsiteTrouble(Integer securityWebsiteTrouble) {
		this.securityWebsiteTrouble = securityWebsiteTrouble;
	}
	public Integer getSecurityGlobalTrouble() {
		return securityGlobalTrouble;
	}
	public void setSecurityGlobalTrouble(Integer securityGlobalTrouble) {
		this.securityGlobalTrouble = securityGlobalTrouble;
	}
	
	
	
}
