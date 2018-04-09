package com.info.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="e_experience")
public class Experience {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;					//������id
	private Date startTime;
	private Date endTime;
	private String jobContent;
	private String others;
	@ManyToOne
	private Employee employee; 		//���һ
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getJobContent() {
		return jobContent;
	}
	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Experience [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", jobContent="
				+ jobContent + ", others=" + others + ", employee=" + employee + "]";
	}
		
}
