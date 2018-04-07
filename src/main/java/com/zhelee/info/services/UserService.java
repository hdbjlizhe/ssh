package com.zhelee.info.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhelee.aspect.CtrlAspect;
import com.zhelee.info.entities.Employee;
import com.zhelee.info.entities.User;
import com.zhelee.info.repository.EmployeeRepository;
import com.zhelee.info.repository.UserRepository;
import com.zhelee.utils.UserUtil;

@Service
public class UserService{
	
	private final static Logger logger= LoggerFactory.getLogger(CtrlAspect.class);
		
	@Autowired
	private UserRepository userRepository;//与数据库交互
	
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * 通过账户查询是否存在此用户
	 * @param account
	 * @return
	 */
	public User findByAcount(String account){
		int userKind=UserUtil.getUserIdKind(account);
		//如果用户类型错误，则返回
		if(userKind==UserUtil.USER_ERROR){
			return null;
		}
		//用户类型无错误，则创建返回结果
		User user=new User();
		//Email账户
		if(userKind==UserUtil.USER_EMAIL){
			user=userRepository.findByEmail(account);
		//手机账户
		}else if (userKind==UserUtil.USER_MOBILE) {
			user=userRepository.findByMobile(account);
		//用户名账户
		}else if(userKind==UserUtil.USER_NAME){
			user=userRepository.findByUsername(account);
		}		
		return user;
	}
	
	/**
	 * 添加用户,添加用户时，也将用户的详细信息类添加
	 * @param user
	 * @return
	 */
	@Transactional
	public User addUser(User user){
		Employee employee=new Employee();
		user.setEmployee(employee);
		employeeRepository.save(employee);
		return userRepository.save(user);
	}
	
	/**
	 * 通过账户名和密码验证此用户
	 * @param account
	 * @param password
	 * @return
	 */
	public User findByAccountAndPassword(String account,String password){		
		
		//获取登录账户的类型（用户名、Email、手机号）
		int userKind=UserUtil.getUserIdKind(account);
		//用户类型错误时
		if(userKind==UserUtil.USER_ERROR)
			return null;
		//定义返回的结果
		User resUser=new User();
		//使用邮箱登录
		if(userKind==UserUtil.USER_EMAIL){
			resUser=userRepository.findByEmailAndPassword(account,password);
		}//使用手机登录
		else if(userKind==UserUtil.USER_MOBILE) {
			resUser=userRepository.findByMobileAndPassword(account,password);
		}//使用用户名登录
		else{
			resUser=userRepository.findByUserNameAndPassword(account,password);
		}
		logger.info("通过帐户和密码查到了用户");
		return resUser;
	}
}
