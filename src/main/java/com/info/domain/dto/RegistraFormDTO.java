package com.info.domain.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;
//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 *  注册表单-数据传输对象
 */
public class RegistraFormDTO {

    @NotEmpty
    @NotNull
    @Size(max = 255)
    private String username;

    @NotEmpty
    @NotNull
    @Size(min = 6,max = 32,message="密码长度应该在6-32之间")
    private String password;

    @NotEmpty
    @NotNull
    @Email(message="邮箱格式不正确")
    private String email;
    
    @NotEmpty
    @NotNull
    private boolean checkbox;
        
	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public CharSequence getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	
}
