package com.zhelee.info.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zhelee.info.entities.User;

@Repository
public class UserDao {

	
//	@Modifying
//	@Query("update User u set u.userName = ?1 where c.id = ?2")
//	int modifyByIdAndUserId(String  userName, Long id);
//	    
//	@Transactional
//	@Modifying
//	@Query("delete from User where id = ?1")
//	void deleteByUserId(Long id);
//	  
//	@Transactional(timeout = 10)
//	@Query("select u from User u where u.emailAddress = ?1")
//	User findByEmailAddress(String emailAddress);
}
