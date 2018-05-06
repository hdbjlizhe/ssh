package com.zhelee.info;

import org.aspectj.weaver.tools.Trace;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Base.class)
public class DemoApplicationTests {
	
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);
	
	@Autowired(required=true)
	PasswordEncoder passwordEncoder;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testPasswordEncoder() {
		//System.out.println(passwordEncoder.encode("123456"));
	}
}
