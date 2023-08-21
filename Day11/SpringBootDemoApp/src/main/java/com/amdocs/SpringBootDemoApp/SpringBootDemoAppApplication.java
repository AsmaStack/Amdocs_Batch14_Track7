package com.amdocs.SpringBootDemoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class SpringBootDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoAppApplication.class, args);
	}

	@RequestMapping(value="/index")
	public String index()
	{
		return "Hello Springboot";
	}
}
