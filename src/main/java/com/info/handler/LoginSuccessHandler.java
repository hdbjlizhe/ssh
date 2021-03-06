package com.info.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import com.info.domain.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  登录成功处理器
 *  需求：
 *  登录成功后，默认跳转到之前的页面
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	
	private static final Logger log = LoggerFactory.getLogger(LoginSuccessHandler.class);


    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException,
            ServletException {
        log.info(authentication.toString());

        log.info(authentication.getPrincipal().toString());//用户对象
        //获得授权后可得到用户信息
        User user = (User) authentication.getPrincipal();
        //输出登录提示信息
        log.info("用户名： " + user.getUsername());
        log.info("用户密码： " + authentication.getCredentials());
        log.info("角色列表："+authentication.getAuthorities());
        log.info("IP信息 :"+authentication.getDetails());
        log.info("是否被授权 :"+authentication.isAuthenticated());
        log.info("Session:"+request.getSession().toString());

        //登录成功后跳转到默认对应的页面
        String targetUrl = "/user/details";
        for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
            String roleName = grantedAuthority.getAuthority();
            switch (roleName){
                case "SUPER":  targetUrl = "/super";break;
                case "ADMIN":  targetUrl = "/admin";break;
                case "VIP":  targetUrl = "/vip";break;
                case "USER":  targetUrl = "/user";break;
            }
        }
        redirectStrategy.sendRedirect(request,response,targetUrl);
    }
    
    //获取登录的IP地址
    public String getIpAddress(HttpServletRequest request){      
        String ip = request.getHeader("x-forwarded-for");      
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
            ip = request.getHeader("Proxy-Client-IP");      
        }      
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
            ip = request.getHeader("WL-Proxy-Client-IP");      
        }      
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
            ip = request.getHeader("HTTP_CLIENT_IP");      
        }      
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");      
        }      
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
            ip = request.getRemoteAddr();      
        }      
        return ip;  
    } 
}
