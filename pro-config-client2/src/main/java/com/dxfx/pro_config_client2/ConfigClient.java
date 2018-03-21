package com.dxfx.pro_config_client2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope
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
