package com.info.domain.dto;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 *  注册表单数据传输对象
 */
public class RegistraFormDTO {

    @NotEmpty
    @NotNull
    @Size(max = 255)
    private String username;

    @NotEmpty
    @NotNull
    @Size(min = 6,max = 32)
    private String password;

    @NotEmpty
    @NotNull
    @Email
    private String email;

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
	

}
