package com.dxfx.pro_eureka_server2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Server2 {
	public static void main(String[] args) {
		SpringApplication.run(Server2.class, args);
	}
}