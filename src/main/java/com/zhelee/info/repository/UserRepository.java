package com.zhelee.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.zhelee.info.entities.User;
import java.lang.String;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);//用户名唯一
	public User findByEmail(String email);
	public User findByMobile(String mobile);
	
	//通过Email和密码查询用户
	@Query("select u from User u where u.email = ?1 and u.password=?2")
	public User findByEmailAndPassword(String account, String password);
	//通过手机号和密码查询用户
	@Query("select u from User u where u.mobile = ?1 and u.password=?2")
	public User findByMobileAndPassword(String account, String password);
	//通过用户名和密码查询用户
	@Query("select u from User u where u.username = ?1 and u.password=?2")
	public User findByUserNameAndPassword(String account, String password);
	
	
}