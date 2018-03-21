package com.dxfx.product.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxfx.product.domain.Product;

@RestController
public class ProductController {

	@RequestMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable String id){
		
		Product product = new Product();
		product.setId(id);
		product.setName("测试产品1");
		product.setPrice(12.2f);
		return product;
	}
	
	
}
