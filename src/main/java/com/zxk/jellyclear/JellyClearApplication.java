package com.zxk.jellyclear;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("mapper")
public class JellyClearApplication {

	public static void main(String[] args) {
		SpringApplication.run(JellyClearApplication.class, args);
	}

}
