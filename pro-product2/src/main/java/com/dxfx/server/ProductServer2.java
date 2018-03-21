package com.dxfx.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.dxfx")
@EnableHystrix
@EnableHystrixDashboard
public class ProductServer2 {

	public static void main(String[] args) {
		SpringApplication.run(ProductServer2.class, args);
	}
}
