package com.zhelee.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class WebConfig {

	@Bean(name = "sitemesh3")
	WebSiteMeshFilter webSiteMeshFilter() {
		return new WebSiteMeshFilter();
	}

	@Bean
	@Order(Integer.MAX_VALUE)
	public FilterRegistrationBean<WebSiteMeshFilter> filterRegistrationBean() {
		// sitemesh3过滤器
		FilterRegistrationBean<WebSiteMeshFilter> registration = new FilterRegistrationBean<WebSiteMeshFilter>();
		registration.setFilter(webSiteMeshFilter());
		registration.setEnabled(true);
		registration.addUrlPatterns("/*");
		registration.setName("sitemesh3");
		return registration;
	}
}