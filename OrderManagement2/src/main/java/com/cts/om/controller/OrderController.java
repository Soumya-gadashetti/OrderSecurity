package com.cts.om.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.om.entities.Order;
import com.cts.om.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/order")
@Api(value = "The Order Controller", description = "Rest controller for order")
public class OrderController {
	@Autowired
	OrderService service;
	
	@ApiOperation(value = "Get all orders",
			produces = "A list of orders",
			notes = "Hit this URL to get all orders details"
			)
	@RequestMapping(method = RequestMethod.GET,value="/all")
	 public List<Order> getOrder(){
		return service.getorders();
	}
	
	@ApiOperation(value = "Get all order by Id",
			produces = "A Order",
			notes = "Hit this URL to get order by id details"
			)	
	@RequestMapping(method = RequestMethod.GET,value="/byId/{orderId}")
	  public Order getOrderById(@PathVariable Long orderId){
	  return service.getOrderById(orderId);
	}
	
	@ApiOperation(value = "Add a order",
			consumes = "A new order is JSON",
			notes = "Hit this URL to insert a new order details"
			)
	
	@RequestMapping(method = RequestMethod.POST, value="/add")
	 public Order addOrder(@RequestBody Order order) {
		return service.addOrder(order);
	}
	
	@ApiOperation(value = "Update a order details",
			consumes = "An existing order in JSON",
			notes = "Hit this URL to update a order details"
			)
	@RequestMapping(method = RequestMethod.PUT,value="/update")
	public Order updateOrder(@RequestBody Order order) throws Exception {
		 return service.updateOrder(order);
	}
	
	@RequestMapping(method= RequestMethod.GET,value="/findbyid/{orderId}")
	public Order findById(@PathVariable Long orderId) {
		return service.findById(orderId);
	}
	
	@ApiOperation(value = "Delete a order",
			consumes = "An existing order id",
			notes = "Hit this URL to delete a order details"
			)
	@RequestMapping(method = RequestMethod.DELETE, value="/deleteId/{orderId}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId){
		ResponseEntity<Void> response=null;
		Order temporder=service.findById(orderId);
		if(temporder==null) {
			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			service.deleteById(orderId);
			response=new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}
	
	
	
	@GetMapping("/default")
	@HystrixCommand(fallbackMethod="getOrder")
	public List<Order> retrieveConfiguration() {
		throw new RuntimeException("Not available");
	}
}
