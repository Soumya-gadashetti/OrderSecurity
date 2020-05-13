package com.cts.om.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.om.entities.Order;
import com.cts.om.entities.OrderItem;
import com.cts.om.entities.Product;
import com.cts.om.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repo;
	@Autowired
	private ProductServiceProxy psp;
	public List<Order> getorders(){
//		return (List<Order>) repo.findAll();
	
		List<Order> orders=(List<Order>) repo.findAll();
		for(Order o:orders) {
			for(OrderItem om:o.getOrderItem()) {
				
				Product product=psp.getProductById(om.getProductId());
//				psp.getProduct(om.getProduct());
				om.setProduct(product);
			}
		}
		return orders;
	}
	
	
	 public Order getOrderById(Long orderId){
			
			Optional<Order> order= repo.findById(orderId);
			 return order.orElse(null);
		}
	
	public Order addOrder(Order order) {
		return repo.save(order);
	}
	
	public void deleteOrder(Long orderId) {
		repo.deleteById(orderId);
	}
	
	public Order updateOrder(Order order) throws Exception { 
		if(order!=null) {
			Order oldorder=repo.findById(order.getOrderId()).orElse(null);
			if(oldorder==null) {
				throw new Exception("does not exist any order");
			}else {
				order=repo.save(order);
			}
		}
		return order;
	}
	
	public Order findById(Long orderId) {
		
		return repo.findById(orderId).orElse(null);
	}
	

	public void deleteById(Long orderId) {
		// TODO Auto-generated method stub
		repo.deleteById(orderId);
	}

}
