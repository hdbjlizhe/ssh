package com.info.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.info.domain.entity.Department;

@Entity
@Table(name="m_depart_Statistics")
public class DepartStatistics implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7967339955188338476L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false)
	@Size(max=7,min=6)
	private String month;//字符串格式的月份
	
	private int website;//局网站
	
	private int newsboard;//内部公告栏
	
	private int webchat;//微信公众号
	
	private int weibo;//微博
	
	private int toutiao;//头条
	
	@ManyToOne
	private Department department;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getWebsite() {
		return website;
	}
	public void setWebsite(int website) {
		this.website = website;
	}
	public int getNewsboard() {
		return newsboard;
	}
	public void setNewsboard(int newsboard) {
		this.newsboard = newsboard;
	}
	public int getWebchat() {
		return webchat;
	}
	public void setWebchat(int webchat) {
		this.webchat = webchat;
	}
	public int getWeibo() {
		return weibo;
	}
	public void setWeibo(int weibo) {
		this.weibo = weibo;
	}
	public int getToutiao() {
		return toutiao;
	}
	public void setToutiao(int toutiao) {
		this.toutiao = toutiao;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
