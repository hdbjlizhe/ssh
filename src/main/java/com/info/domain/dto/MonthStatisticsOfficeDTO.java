package com.info.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MonthStatisticsOfficeDTO {
	
	private Long id;
	//处理公文项数
	@NotEmpty
	@NotNull
	private Integer docOffice;
	//配合相关处室完成工作
	@NotEmpty
	@NotNull
	private Integer docDepart;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getDocOffice() {
		return docOffice;
	}
	public void setDocOffice(Integer docOffice) {
		this.docOffice = docOffice;
	}
	public Integer getDocDepart() {
		return docDepart;
	}
	public void setDocDepart(Integer docDepart) {
		this.docDepart = docDepart;
	}
	
}
