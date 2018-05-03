package com.info.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.info.domain.entity.Duty;

@Entity
@Table(name="eva_map")
public class EvaluationMap implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -413251619253019051L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//考核对象
	@ManyToOne
	private Duty object;//考核对象
	//考官级别区间	
	@ManyToOne
	private Duty maxScorer;//最高级别打分人
	@ManyToOne
	private Duty minScorer;//最低级别打分人
	
	private boolean departDivided;//是否区分部门
	
	private boolean excludInformal;//排除非正式员工
	
	private boolean includingSelf;//是否包含自己
	//比重
	private float proportions;
	
	
	public EvaluationMap() {
		this.departDivided=true;
		this.excludInformal=true;
		this.includingSelf=true;
	}


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


	public Duty getMaxScorer() {
		return maxScorer;
	}


	public void setMaxScorer(Duty maxScorer) {
		this.maxScorer = maxScorer;
	}


	public Duty getMinScorer() {
		return minScorer;
	}


	public void setMinScorer(Duty minScorer) {
		this.minScorer = minScorer;
	}


	public boolean isDepartDivided() {
		return departDivided;
	}


	public void setDepartDivided(boolean departDivided) {
		this.departDivided = departDivided;
	}


	public boolean isExcludInformal() {
		return excludInformal;
	}


	public void setExcludInformal(boolean excludInformal) {
		this.excludInformal = excludInformal;
	}

	public boolean isIncludingSelf() {
		return includingSelf;
	}


	public void setIncludingSelf(boolean includingSelf) {
		this.includingSelf = includingSelf;
	}


	public float getProportions() {
		return proportions;
	}


	public void setProportions(float proportions) {
		this.proportions = proportions;
	}
			
}
