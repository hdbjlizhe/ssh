package com.info.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.info.domain.JsonResult;
import com.info.handler.WebExceptionHandler;

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
	
	@Autowired
    private WebExceptionHandler exceptionHandle;
	
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
		logger.info("method={}",request.getRemoteAddr());
		//类方法
		logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName());
		//参数
		logger.info("class_method_attrs={}",joinPoint.getArgs());
	}
	
	@Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        JsonResult<Object> result = null;
        try {

        } catch (Exception e) {
            //return exceptionHandle.exceptionGet(e);
        }
        if(result == null){
            return proceedingJoinPoint.proceed();
        }else {
            return result;
        }
    }

    @AfterReturning(pointcut = "log()",returning = "object")//打印输出结果
    public void doAfterReturing(Object object){
        logger.info("response={}",object.toString());
    }
    
	@After("log()")
	public void doAfter(JoinPoint joinPoint){
		logger.info(joinPoint.getSignature().getDeclaringTypeName()+"方法执行完毕");
	}
	
	@AfterReturning(returning="object",pointcut="log()")
	public void doAfterReturning(Object object){
		logger.info("response={}",object);
	}
}
