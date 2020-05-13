package com.cts.om.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="orders")
@Data
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;

	@Column(unique=true)
	private String orderDate;

	@NotNull
	@Column(unique=true)
	private double orderPrice;

	@JsonManagedReference
	@OneToMany(mappedBy="order",fetch = FetchType.LAZY)
	private List<OrderItem> orderItem;

	public Order() {
		super();
	} 


	public Order(Long orderId, String orderDate, double orderPrice, List<OrderItem> orderItem) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
		this.orderItem = orderItem;
	}

	public Order(Long orderId, String orderDate,  double orderPrice) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
	}





}
