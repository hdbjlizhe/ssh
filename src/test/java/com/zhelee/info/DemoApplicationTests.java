package com.zhelee.info;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import com.info.utils.LocaleUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	
	private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Test
	public void testJavaMailSender() throws Exception{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("hdbjlizhe@163.com");
		message.setTo("282617666@qq.com");
		message.setSubject("主题：简单邮件");
		message.setText("简单邮件内容");
		mailSender.send(message);
	}
	
	@Test
	public void testLocaleUtil() {
		log.info(LocaleUtil.getAttribute("msg.mail.confirm"));
	}
}
