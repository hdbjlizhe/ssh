package com.info.domain.entity;


import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "t_resource")
public class Resource implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1937359425030984861L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;			//资源ID
	private String uri;			//资源名称
	private String description;	//资源描述
	private String methodPath;	//对应的方法

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "resources")
	private Set<Role> roles = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getMethodPath() {
		return methodPath;
	}

	public void setMethodPath(String methodPath) {
		this.methodPath = methodPath;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", uri=" + uri + ", description=" + description + ", methodPath=" + methodPath
				+ ", roles=" + roles + "]";
	}
	
}
