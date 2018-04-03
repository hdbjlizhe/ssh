package com.zhelee.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 */
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

	/**
	 * 登录session key
	 */
	public final static String SESSION_KEY = "user";

	@Bean
	public SecurityInterceptor getSecurityInterceptor() {
		return new SecurityInterceptor();
	}

	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
		// 排除配置
		addInterceptor.excludePathPatterns("/");
		addInterceptor.excludePathPatterns("/error");
		addInterceptor.excludePathPatterns("/login**");
		addInterceptor.excludePathPatterns("/index");
		addInterceptor.excludePathPatterns("/register");
		addInterceptor.excludePathPatterns("/css/*");
		addInterceptor.excludePathPatterns("/fonts/*");
		addInterceptor.excludePathPatterns("/imgs/*");
		addInterceptor.excludePathPatterns("/js/*");
		addInterceptor.excludePathPatterns("/user-validateAccount");
		addInterceptor.excludePathPatterns("/about");
		// 拦截配置
		addInterceptor.addPathPatterns("/**");
	}

	
	/**
	 * 
	 * 内部类,安全拦截器
	 * @author Lee
	 *
	 */
	private class SecurityInterceptor extends HandlerInterceptorAdapter {
		
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			HttpSession session = request.getSession();
			// 如果是登录用户
			if (session.getAttribute(SESSION_KEY) != null) {
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
}