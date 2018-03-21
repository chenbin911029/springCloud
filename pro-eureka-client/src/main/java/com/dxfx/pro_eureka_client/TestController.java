package com.dxfx.pro_eureka_client;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {

//	@Autowired
//	private EurekaClient discoveryClient;

	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Resource
	private RestTemplate restTemplate;
	
	@Resource
	private FeignProductService productService;
	
	@RequestMapping("/getServer")
	public Object getServer(){
//		InstanceInfo instance = discoveryClient.getNextServerFromEureka("eureka-client", false);
		List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client");
		List<String> hosts = new ArrayList<String>();
		for(ServiceInstance instance : instances){
			hosts.add(instance.getHost());
		}
		
		return hosts;
	}
	
	
	@RequestMapping("/getProductInfoByFeign")
	public Object getProductInfoByFeign(){
		Object result = productService.getProductById("12");
		return result;
	}
	
	
	
	@RequestMapping("/getProductInfo")
	@HystrixCommand(fallbackMethod="error")
	public Object getProductInfo(){
		List<ServiceInstance> instances = discoveryClient.getInstances("pro-product");
		String url = instances.get(0).getUri().toString();
		Object result = restTemplate.getForObject(url+"/getProductById/13", Object.class);
		return result;
	}
	
	
	
	
	@RequestMapping("/loadBalanceGetProductInfo")
	@HystrixCommand(fallbackMethod="error")
	public Object loadBalanceGetProductInfo(){
		Object result = restTemplate.getForObject("http://pro-product/getProductById/13", Object.class);
		return result;
	}
	
	
	public String error(){
		return "这是Hystrix返回的";
	}
}
