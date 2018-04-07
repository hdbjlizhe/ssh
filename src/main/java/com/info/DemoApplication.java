package com.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.io.IOException;  
import javax.annotation.PostConstruct;  
  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;  
import com.info.config.security.Appctx;
import com.info.config.security.MyFilterSecurityInterceptor;
import com.info.config.security.SResourceService; 

@SpringBootApplication
//扫描所有需要的包
@ComponentScan(basePackages = "com.info")
//开启定时任务
@EnableScheduling
//开启异步方法
@EnableAsync
 
@EnableAutoConfiguration(exclude = MyFilterSecurityInterceptor.class) //注意  
public class DemoApplication{  
      
    @Autowired  
    private SResourceService sresourceService;  
      
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);  
    @PostConstruct  
     public void initApplication() throws IOException {  
         log.info("Running with Spring profile(s) : {}");   
    }  
       
    public static void main(String[] args) {  
        //SpringApplication.run(MainApplication.class, args);  
        SpringApplication app=new SpringApplication(DemoApplication.class);       
        Appctx.ctx=app.run(args);  
        /*UserService suserService = (UserService) Appctx.ctx.getBean("suserService"); 
        SysUser su= suserService.findByName("user"); 
        System.out.println("密码"+su.getPassword()); 
        System.out.println("名字"+su.getName()); 
        BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);//将密码加密 
        su.setPassword(bc.encode(su.getPassword())); 
        System.out.println("密码"+su.getPassword()); 
        suserService.update(su);*/  
}  
}  
