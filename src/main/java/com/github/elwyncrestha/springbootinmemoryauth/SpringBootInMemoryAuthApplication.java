package com.github.elwyncrestha.springbootinmemoryauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.github.elwyncrestha.springbootinmemoryauth.api")
@EntityScan(basePackages = "com.github.elwyncrestha.springbootinmemoryauth.api")
@ComponentScan(basePackages = "com.github.elwyncrestha")
@EnableSwagger2
public class SpringBootInMemoryAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInMemoryAuthApplication.class, args);
	}

}
