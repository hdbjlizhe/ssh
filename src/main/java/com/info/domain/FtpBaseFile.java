package com.info.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ftpbasefile")
public class FtpBaseFile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;//文件ID
	@Column(nullable=false)
	private String name;//文件名
	private String path;//文件路径
	private Date uploadTime;//修改时间
	private String extension;//扩展名
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	@Override
	public String toString() {
		return "FtpBaseFile [id=" + id + ", name=" + name + ", path=" + path + ", uploadTime=" + uploadTime
				+ ", extension=" + extension + "]";
	}
	
}
