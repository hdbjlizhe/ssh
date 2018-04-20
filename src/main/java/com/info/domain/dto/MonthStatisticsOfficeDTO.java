package com.info.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MonthStatisticsOfficeDTO {
	//处理公文项数
	@NotEmpty
	@NotNull
	private int docOffice;
	//配合相关处室完成工作
	@NotEmpty
	@NotNull
	private int docDepart;
	public int getDocOffice() {
		return docOffice;
	}
	public void setDocOffice(int docOffice) {
		this.docOffice = docOffice;
	}
	public int getDocDepart() {
		return docDepart;
	}
	public void setDocDepart(int docDepart) {
		this.docDepart = docDepart;
	}
	
}
