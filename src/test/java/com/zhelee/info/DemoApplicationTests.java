package com.zhelee.info;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Base.class)
public class DemoApplicationTests {

	
	@Test
	public void contextLoads() {
	}
	
}
