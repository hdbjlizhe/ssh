package com.zhelee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zhelee.interceptors.SecurityInterceptor;

/**
 *
 */
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

	//登录session key
	public final static String SESSION_KEY = "user";
	//不进行拦截的路径
	private String[] exludePaths= {
			
			"/css/*",		//样式文件
			"/fonts/*",		//字体文件
			"/imgs/*",		//图片文件
			"/js/*",		//JavaScript文件
			
			"/",			//首页
			"/index",		//首页
			"/error",		//错误页
			"/login",		//登录页
			"/register",	//注册页
			"/about",		//关于页
			
			//Ajax路径
			"/user-validateAccount",//用户名检查是否可用路径
			
			//Sitemesh装饰器路径
			"/decorators/*",
			//javascript脚本
			"javascript:;"
			
	};
	
	@Bean
	public SecurityInterceptor getSecurityInterceptor() {
		return new SecurityInterceptor();
	}

	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
		//拦截配置
		addInterceptor.addPathPatterns("/**");
		addInterceptor.excludePathPatterns(exludePaths);
	}
	
}