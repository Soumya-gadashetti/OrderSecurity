package com.cts.pm.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pm.entities.Product;
import com.cts.pm.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public List<Product> getproducts(){
		return (List<Product>) repo.findAll();
	}
	
	 public Product getProductById(Long productId){
		
		Optional<Product> product= repo.findById(productId);
		 return product.orElse(null);
	}
	
	public void addProduct(Product product) {
		repo.save(product);
	}
	
	public void deleteProduct(Long productId) {
		repo.deleteById(productId);
	}
	
	public void updateProduct(Product product) {
		repo.save(product);
	}
}
