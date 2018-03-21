package com.dxfx.product.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxfx.product.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ProductController {

	@RequestMapping("/getProductById/{id}")
	@HystrixCommand(fallbackMethod="error")
	public Product getProductById(@PathVariable String id){
		
		Product product = new Product();
		product.setId(id);
		product.setName("测试产品2");
		product.setPrice(12.2f);
		return product;
	}
	
	public Product error(String id){
		return new Product();
	}
	
}
