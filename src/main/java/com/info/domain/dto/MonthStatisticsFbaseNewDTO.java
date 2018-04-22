package com.info.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MonthStatisticsFbaseNewDTO {

	private Long id;
	@NotEmpty
	@NotNull
	private Integer fbaseNew;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getFbaseNew() {
		return fbaseNew;
	}
	public void setFbaseNew(Integer fbaseNew) {
		this.fbaseNew = fbaseNew;
	}
	
}
