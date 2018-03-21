package com.dxfx.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.dxfx")
public class ProductServer1 {

	public static void main(String[] args) {
		SpringApplication.run(ProductServer1.class, args);
	}
}
