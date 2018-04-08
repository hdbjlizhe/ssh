package com.info.domain.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class RememeberMe {
	private String username;
	private String serie;
	private String token;
	private Timestamp lastUsed;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Timestamp getLastUsed() {
		return lastUsed;
	}
	public void setLastUsed(Timestamp lastUsed) {
		this.lastUsed = lastUsed;
	}
	
	
}
