package com.cts.pm.controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pm.entities.Product;
import com.cts.pm.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product")
@Api(value = "The Product Controller", description = "Rest controller for Product")
public class ProductController {
	@Autowired
	ProductService service;
	
	@ApiOperation(value = "Get all Product",
			produces = "A list of Product",
			notes = "Hit this URL to get all Product details"
			)
	@RequestMapping("/all")
	List<Product> getProduct(){
		return service.getproducts();
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/byId/{productId}")
//	Optional<Product> getProductById(@PathVariable Long productId){
	 Product getProductById(@PathVariable Long productId){
	  return service.getProductById(productId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/add")
	void addProduct(@RequestBody Product product) {
		service.addProduct(product);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	void updateProduct(@RequestBody Product product) {
		service.updateProduct(product);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deleteId")
	void deleteProduct(@PathVariable Long productId) {
		service.deleteProduct(productId);
	}
}
