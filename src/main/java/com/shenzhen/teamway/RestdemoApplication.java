package com.shenzhen.teamway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.shenzhen.teamway.mapper")
@SpringBootApplication
public class RestdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestdemoApplication.class, args);
	}

}
