package com.info.utils;

import com.info.utils.RegexUtil;

public class UserUtil {
	
	public final static int USER_ERROR=-1;		// 用户错误
	public final static int USER_NAME = 0; 		// 用户名
	public final static int USER_MOBILE = 1; 	// 手机号
	public final static int USER_EMAIL = 2; 	// Email

	/**
	 * 通过用户ID获取用户ID的种类，用户名：手机号：Email
	 * @param userId
	 * @return
	 */
	public static int getUserIdKind(String userId){
		
		if(userId.matches(RegexUtil.REGEX_MOBILE)){//判断是否手机号
			return USER_MOBILE;
		}else if (userId.matches(RegexUtil.REGEX_EMAIL)) {//判断是否Email
			return USER_EMAIL;	
		}else if(userId.matches(RegexUtil.REGEX_USERNAME)){//其他均为用户名
			return USER_NAME;
		}else {
			return USER_ERROR;
		}
	}
}
