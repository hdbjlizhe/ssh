package com.info.config.security;

import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.String;
import com.info.config.security.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Integer> {

	SysUser findByName(String name);
}
