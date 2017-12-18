package com.hebao.hbservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HebaoApplicationtests {

	@Value("${demo.configStr}")
	private String str;

	@Test
	public void contextLoads() {
		Assert.assertEquals(str, "xxx");
	}

}
