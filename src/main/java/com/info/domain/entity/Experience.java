package com.info.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="e_experience")
public class Experience implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5826825377367927112L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;					//id
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;
	private String jobContent;
	private String others;
	@ManyToOne
	private Employee employee; 		//���һ
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
