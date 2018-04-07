package com.info.config.global;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
/**
 * 统一异常处理类
 * @author Lee
 */
@ControllerAdvice
public class WebExceptionHandler {
	
	private final static Logger logger=LoggerFactory.getLogger(WebExceptionHandler.class);
	
	private static final String ERROR_VIEW = "error";
	
	//错误处理函数
	public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
		e.printStackTrace();
		if (isAjax(request)) {
			return response;
		} else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("exception", e);
			mav.addObject("url", request.getRequestURL());
			mav.setViewName(ERROR_VIEW);
			return mav;
		}
		
	}
	//判断是否为Ajax请求
	private boolean isAjax(HttpServletRequest request) {
		return (request.getHeader("X-Requested-With") != null
				&& "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
	}
}
