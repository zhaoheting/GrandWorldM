package com.example.GrandWorldM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = { "com.example.GrandWorldM.controllers" })
public class GrandWorldMApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrandWorldMApplication.class, args);
	}

}
