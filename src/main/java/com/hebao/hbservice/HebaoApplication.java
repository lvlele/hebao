package com.hebao.hbservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hebao.hbservice.mapper")
public class HebaoApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(HebaoApplication.class);
		application.setWebEnvironment(true);
		application.run(args);
	}
}
