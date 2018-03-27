package com.zhelee.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
 @Bean(name = "sitemesh3")   
 WebSiteMeshFilter webSiteMeshFilter() {   
     return new WebSiteMeshFilter();  
  }   

@Bean 
public FilterRegistrationBean<WebSiteMeshFilter> filterRegistrationBean(@Qualifier("sitemesh3")WebSiteMeshFilter siteMeshFilter) {   
     FilterRegistrationBean<WebSiteMeshFilter> filterRegistrationBean = new FilterRegistrationBean<WebSiteMeshFilter>();             
     filterRegistrationBean.setFilter(siteMeshFilter);        
     filterRegistrationBean.setEnabled(true);        
    filterRegistrationBean.addUrlPatterns("/*");        
    return filterRegistrationBean;   
  }
}