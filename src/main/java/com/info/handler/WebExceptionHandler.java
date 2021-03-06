package com.info.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.web.authentication.rememberme.CookieTheftException;

/**
 * 统一异常处理类
 * @author Lee
 */
@ControllerAdvice
public class WebExceptionHandler {

	private final static Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

	private static final String ERROR_VIEW = "error";
	// private static final String ERROR_VIEW = "deny";

	// 错误处理函数
	@ExceptionHandler(value = Exception.class)
	public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
		logger.info("统一的异常处理函数");
		// e.printStackTrace();
		if (isAjax(request)) {
			return response;
		} else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("exception", e);
			mav.addObject("url", request.getRequestURL());
			mav.setViewName(ERROR_VIEW);
			if(e instanceof CookieTheftException)
			{
				logger.info("CookieTheftException");
				mav.addObject("message","您的Cookie存在被盗风险，请检查！");
			}
			
			return mav;
		}

	}
	// 判断是否为Ajax请求
	private boolean isAjax(HttpServletRequest request) {
		return (request.getHeader("X-Requested-With") != null
				&& "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
	}


}
