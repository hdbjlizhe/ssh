package com.info.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EvaluationEmployeeDTO{

	@NotNull
	@NotEmpty
	private String id;
	@NotNull
	@NotEmpty
	private String toWhom;//给谁打的分
	@NotNull
	@NotEmpty
	private String season;//季度
	@NotNull
	@NotEmpty
	private String morality;//德
	@NotNull
	@NotEmpty
	private String ability;//能
	@NotNull
	@NotEmpty
	private String diligence;//勤
	@NotNull
	@NotEmpty
	private String achievement;//绩
	@NotNull
	@NotEmpty
	private String honest;//廉
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getToWhom() {
		return toWhom;
	}
	public void setToWhom(String toWhom) {
		this.toWhom = toWhom;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getMorality() {
		return morality;
	}
	public void setMorality(String morality) {
		this.morality = morality;
	}
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability;
	}
	public String getDiligence() {
		return diligence;
	}
	public void setDiligence(String diligence) {
		this.diligence = diligence;
	}
	public String getAchievement() {
		return achievement;
	}
	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	public String getHonest() {
		return honest;
	}
	public void setHonest(String honest) {
		this.honest = honest;
	}
	
}
