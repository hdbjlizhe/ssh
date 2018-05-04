package com.info.domain.pojo;

import com.info.domain.entity.Employee;

public class EvaluationResult {
	private Employee object;//对象
	private Float sum;
	
	public Employee getObject() {
		return object;
	}
	public void setObject(Employee object) {
		this.object = object;
	}
	public Float getSum() {
		return sum;
	}
	public void setSum(Float sum) {
		this.sum = sum;
	}
	
}
