package com.java.sboot.springboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.java.sboot.controllers,com.java.sboot.entity")
public class SpringbootTestApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringbootTestApplication.class, args);
	}}
