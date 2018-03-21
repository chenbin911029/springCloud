package com.dxfx.pro_eureka_client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value="pro-product")
public interface FeignProductService {
	
	@RequestMapping(value="/getProductById/{id}",method=RequestMethod.GET)
	public Product getProductById(@PathVariable(value="id") String id);

}
