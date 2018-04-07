package com.info.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.info.utils.UserUtil;

/**
 *使用JPA定义用户。实现UserDetails接口，用户实体即为springSecurity所使用的用户。
 * @author Lee
 *
 */
@Entity
@Table(name = "user")
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	@Column(unique=true)//唯一
	private String portrait; // uuid
	@Column(unique=true)//唯一
	private String username; // User Name
	@Column(unique=true)//唯一
	private String mobile; // Mobile Number
	@Column(unique=true)//唯一
	private String email; // Email
	private String password; // Password
	private Boolean accountNonExpired=true;//账户是否未过期
	private Boolean accountNonLocked=true;//账户未被锁定
	private Boolean credentialsNonExpired=true;//证书未过期
	private Boolean enabled=true;//账户是否可用
	
	//FetchType.EAGER：急加载。在加载一个实体的时候，
	//其中定义是急加载的的属性(property)和字段(field)
	//会立即从数据库中加载 
    //CascadeType:级联更新
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<Role> roles;
	
    // 员工
	@OneToOne
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		if(accountNonExpired==null)
			this.accountNonExpired=true;
		else
			this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		if(accountNonLocked==null)
			this.accountNonLocked=true;
		else 
			this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		if(credentialsNonExpired==null)
			this.credentialsNonExpired=true;
		else 
			this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(Boolean enabled) {
		if(enabled==null)
			this.enabled=true;
		else
			this.enabled = enabled;
	}

	//根据account类型分别设置
	public void setAcount(String account) {
		
		int userIdKind=UserUtil.getUserIdKind(account);
		
		if(userIdKind==UserUtil.USER_EMAIL) {
			setEmail(account);
		}else if (userIdKind==UserUtil.USER_MOBILE) {
			setMobile(account);
		}else if(userIdKind==UserUtil.USER_NAME){
			setUsername(account);
		}else if(userIdKind==UserUtil.USER_ERROR){
			return;
		}
		
	}

	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	
}
