package com.dxfx.pro_config_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClient {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClient.class, args);
	}
	
	
@Value("${mysql.host}")
private String mysqlHost;


@RequestMapping("/getProperty")
public Object getProperty(){
	return mysqlHost;
}

	
}
