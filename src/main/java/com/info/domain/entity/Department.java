package com.info.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="e_department")
public class Department implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8919425568944361347L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	//处室名称
	private String departmentName;
	//处室正职
	@OneToOne
	private Employee departmentPrincipal;
	//处室副职
	@OneToOne
	private Employee departmentDeputy;
	//分管的副局长
	@ManyToOne
	private Employee deputyBureau;
	
	private String decription;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Employee getDepartmentPrincipal() {
		return departmentPrincipal;
	}
	public void setDepartmentPrincipal(Employee departmentPrincipal) {
		this.departmentPrincipal = departmentPrincipal;
	}
	public Employee getDepartmentDeputy() {
		return departmentDeputy;
	}
	public void setDepartmentDeputy(Employee departmentDeputy) {
		this.departmentDeputy = departmentDeputy;
	}
	public Employee getDeputyBureau() {
		return deputyBureau;
	}
	public void setDeputyBureau(Employee deputyBureau) {
		this.deputyBureau = deputyBureau;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}

}
