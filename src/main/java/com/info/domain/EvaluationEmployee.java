package com.info.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.info.domain.entity.Employee;

@Entity
@Table(name="eva_season")
public class EvaluationEmployee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Employee toWhom;//给谁打的分
	@Column(nullable=false)
	private String season;//季度
	private float morality;//德
	private float ability;//能
	private float diligence;//勤
	private float achievement;//绩
	private float honest;//廉
	private float sum;//总分
	@ManyToOne
	private Employee fromWhom;//谁打的分
	private Date createTime;//提交时间
	private Date updateTime;//最后一次修改时间
	
	public EvaluationEmployee() {
		super();
		morality=0f;//德
		ability=0f;//能
		diligence=0f;//勤
		achievement=0f;//绩
		honest=0f;//廉
		sum=0f;//总分
		createTime=new Date();
		updateTime=new Date();
	}
	/************************************************************************************************************
	 * Getter and Setter
	 ************************************************************************************************************/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Employee getToWhom() {
		return toWhom;
	}
	public void setToWhom(Employee toWhom) {
		this.toWhom = toWhom;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
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
	public Employee getFromWhom() {
		return fromWhom;
	}
	public void setFromWhom(Employee fromWhom) {
		this.fromWhom = fromWhom;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public float getSum() {
		return sum;
	}
	public void setSum() {
		this.sum = this.morality+this.ability+this.diligence+this.achievement+this.honest;
	}
	@Override
	public String toString() {
		return "EmployeeEvaluation [id=" + id + ", toWhom=" + toWhom + ", season=" + season + ", morality=" + morality
				+ ", ability=" + ability + ", diligence=" + diligence + ", achievement=" + achievement + ", honest="
				+ honest + ", fromWhom=" + fromWhom + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}		
}
