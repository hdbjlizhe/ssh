package com.info.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "t_role")
public class Role {
	//角色ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //角色ID
    private String roleName;	
    //有此角色的所有用户
    @ManyToMany(targetEntity = User.class,mappedBy = "roles",fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();
    //属于此角色的所有资源
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "t_role_resources",
            joinColumns = { @JoinColumn(name = "roles_id") },
            inverseJoinColumns = { @JoinColumn(name = "resources_id") })
    private Set<Resource> resources = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

}
