package com.info.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * 1.加入spring-boot-start-aop的支持
 * 2.编写aop类并注释Aspect,通过Component注释使用Spring管理
 * @author lizhe
 *
 */

@Aspect
@Component
public class CtrlAspect {
	
	private final static Logger logger= LoggerFactory.getLogger(CtrlAspect.class);
		
	@Pointcut("execution(* com.info.controllers.*.*(..))")
	public void log(){
		
	}	
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		//获取Request
		ServletRequestAttributes attrs=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request=attrs.getRequest();
		//url
		logger.info("url={}",request.getRequestURL());
		//method
		logger.info("method={}",request.getMethod());
		//ip
		logger.info("RemoteAddr={}",request.getRemoteAddr());
		//类方法
		logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName());
		//参数
		logger.info("class_method_attrs={}",joinPoint.getArgs());
	}
	
    @AfterReturning(pointcut = "log()",returning = "object")//打印输出结果
    public void doAfterReturing(Object object){
        logger.info("response={}",object.toString());
    }
    
	@After("log()")
	public void doAfter(JoinPoint joinPoint){
		logger.info(joinPoint.getSignature().getDeclaringTypeName()+"方法执行完毕");
	}
	
}
