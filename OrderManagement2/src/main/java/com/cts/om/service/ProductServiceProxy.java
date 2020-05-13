package com.cts.om.service;

//import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import java.util.Optional;

import com.cts.om.entities.Product;
@FeignClient(name="product-service",url ="localhost:4001")  
public interface ProductServiceProxy {
//	 public Product getProductById(Long productId);
	@RequestMapping(method = RequestMethod.GET,value="product/byId/{productId}")
//	@RequestMapping(method = RequestMethod.GET,value="product/byId")
	 Product getProductById(@PathVariable Long productId);
	
//	@RequestMapping("/all")
//	List<Product> getProduct(Product product);
//	List<Product> getProduct();
//	public void getProductId();

}
