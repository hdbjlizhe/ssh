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

	@PostConstruct
	public void initApplication() throws IOException {
		log.info("Running with Spring profile(s) : {}");
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
