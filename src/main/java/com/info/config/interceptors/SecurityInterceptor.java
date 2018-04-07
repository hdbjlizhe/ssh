package com.zhelee.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zhelee.config.WebSecurityConfig;

public class SecurityInterceptor extends HandlerInterceptorAdapter {	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		// 如果是登录用户
		if (session.getAttribute(WebSecurityConfig.SESSION_KEY) != null) {
			return true;
		}
		// 非登录用户， 跳转登录
		//String url = "/login";显示权限不足
		response.getWriter().write("<script language=\"javascript\">alert('\\u6743\\u9650\\u4e0d\\u8db3,\\u8bf7\\u767b\\u5f55')</script>");
		//返回原来页面
		response.getWriter().write("<script language=\"javascript\">window.history.back(-1);</script>");
		//response.sendRedirect(url);
		return false;
	}
}
