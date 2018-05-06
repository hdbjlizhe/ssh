package com.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.info.domain.entity.Resource;
import com.info.service.impl.ResourceService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
// 扫描所有需要的包
@ComponentScan(basePackages = "com.info")
// 开启定时任务
@EnableScheduling
// 开启异步方法
@EnableAsync

@EnableAutoConfiguration
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;
	
	@Autowired
	private ResourceService resourceService;

	@PostConstruct
	public void initApplication() throws IOException {
		log.info("Running with Spring profile(s) : {}");
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	//这个注解很重要，可以在每次启动的时候检查是否有URL更新，RequestMappingHandlerMapping只能在controller层用。这里我们放在主类中
	@PostConstruct  
    public void detectHandlerMethods(){  
           //final RequestMappingHandlerMapping requestMappingHandlerMapping = requestMappingHandlerConfig.requestMappingHandlerMapping ();  
           Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();  
           Set<RequestMappingInfo> mappings = map.keySet();  
           //Map<String, String> reversedMap = new HashMap<String, String>();  
           for(RequestMappingInfo info : mappings) {  
               HandlerMethod method = map.get(info);  
               String methodstr = method.toString();  
               methodstr = methodstr.split("\\(")[0];  
               methodstr = methodstr.split(" ")[2];  
               int i=methodstr.lastIndexOf(".");  
               methodstr = methodstr.substring(0,i);  
               String urlparm = info.getPatternsCondition().toString();  
               String url = urlparm.substring(1, urlparm.length()-1);  
               List<Resource> list = resourceService.findByResourceString(url);  
               if(list==null || list.size()<=0){  
                   //int num = (int)(Math.random()*100+1);  
                   //String rand = String.valueOf(num);  
                   //String resourceId = "res"+System.currentTimeMillis()+rand;  
                   Resource sysresource = new Resource();  
                   sysresource.setUri(url);  
                   sysresource.setDescription("0");  
                   sysresource.setMethodPath(methodstr);  
                   resourceService.save(sysresource);  
                   log.info("===>"+url);  
               }  
                 
           }  
       }
}
