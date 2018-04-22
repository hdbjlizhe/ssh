package com.info.domain.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MonthStatisticsAffairsDTO {
	
	private Long id;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private Integer affairs;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAffairs() {
		return affairs;
	}
	public void setAffairs(Integer affairs) {
		this.affairs = affairs;
	}
	
}
