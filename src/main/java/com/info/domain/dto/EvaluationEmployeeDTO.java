package com.info.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EvaluationEmployeeDTO{

	private Long id;
	@NotNull
	@NotEmpty
	private Long toWhom;//给谁打的分
	@NotNull
	@NotEmpty
	private int season;//季度
	@NotNull
	@NotEmpty
	private float morality;//德
	@NotNull
	@NotEmpty
	private float ability;//能
	@NotNull
	@NotEmpty
	private float diligence;//勤
	@NotNull
	@NotEmpty
	private float achievement;//绩
	@NotNull
	@NotEmpty
	private float honest;//廉
	
	public EvaluationEmployeeDTO() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getToWhom() {
		return toWhom;
	}
	public void setToWhom(Long toWhom) {
		this.toWhom = toWhom;
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public float getMorality() {
		return morality;
	}
	public void setMorality(float morality) {
		this.morality = morality;
	}
	public float getAbility() {
		return ability;
	}
	public void setAbility(float ability) {
		this.ability = ability;
	}
	public float getDiligence() {
		return diligence;
	}
	public void setDiligence(float diligence) {
		this.diligence = diligence;
	}
	public float getAchievement() {
		return achievement;
	}
	public void setAchievement(float achievement) {
		this.achievement = achievement;
	}
	public float getHonest() {
		return honest;
	}
	public void setHonest(float honest) {
		this.honest = honest;
	}
}
