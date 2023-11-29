package com.brohan.simpleapi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;


@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SimpleapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleapiApplication.class, args);
	}



}
