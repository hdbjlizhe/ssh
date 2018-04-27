package com.info.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.info.domain.entity.Duty;

@Entity
@Table(name="eva_map")
public class EvaluationMap {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//考核对象
	@OneToOne
	private Duty object;
	//考官级别区间
	@OneToOne
	private Duty dutyMax;
	@OneToOne
	private Duty dutyMin;
	//比重
	private float proportion;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Duty getObject() {
		return object;
	}
	public void setObject(Duty object) {
		this.object = object;
	}
	
	public Duty getDutyMax() {
		return dutyMax;
	}
	public void setDutyMax(Duty dutyMax) {
		this.dutyMax = dutyMax;
	}
	public Duty getDutyMin() {
		return dutyMin;
	}
	public void setDutyMin(Duty dutyMin) {
		this.dutyMin = dutyMin;
	}
	public float getProportion() {
		return proportion;
	}
	public void setProportion(float proportion) {
		this.proportion = proportion;
	}
	
}
