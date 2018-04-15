package com.info.domain.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *  这里不能使用lombok  @Data注解 否则会出现@ManyToMany死循环导致内存溢出
 *  否则就是org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: cn.geekview.domain.entity.User.roles, could not initialize proxy - no Session
 *
 */
@Entity
@Table(name = "t_user")
public class User implements UserDetails{

    /**
	 * 
	 */
	private static final long serialVersionUID = 7338242326065902233L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;
    
    private String mobile;
    
    private Boolean accountNonExpired;//账户未过期
    
    private Boolean accountNonLocked;//账记未被锁定
    
    private Boolean credentialsNonExpired;//证书未过期

    /*
        AbstractUserDetailsAuthenticationProvider的私有内部类DefaultPreAuthenticationChecks会对用户是否可用进行校验
     */
    private boolean enabled;
    
    @OneToOne
    
    private Employee employee;//对应个人具体信息

    public User(){
        this.enabled = false;
        this.accountNonExpired=false;
        this.accountNonLocked=false;
        this.credentialsNonExpired=false;
        //this.employee=new Employee();
    }

    /**
     *  CascadeType.DETACH
     Cascade detach operation，级联脱管/游离操作。
     如果你要删除一个实体，但是它有外键无法删除，你就需要这个级联权限了。它会撤销所有相关的外键关联。
     */
    @ManyToMany(targetEntity = Role.class,fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : roles) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
            grantedAuthorities.add(simpleGrantedAuthority);
        }
        return grantedAuthorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }
    public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }
    public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setEmployee(Employee employee) {
		this.employee=employee;
	}
	
	public Employee getEmployeee() {
		return employee;
	}
    
    
}
