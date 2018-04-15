package com.info.domain.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="persistent_logins")
public class RememeberMe implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4578575034524182660L;
	@NotNull
	private String username;
	@Id
	private String series;
	@NotNull
	private String token;
	@NotNull
	private Timestamp lastUsed;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSeries() {
		return series;
	}
	public void setSerie(String serie) {
		this.series = serie;
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
