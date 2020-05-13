package com.cts.om.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(description = "This is the orderitem model")
@Entity
@Table(name="orderitem")
@Data
public class OrderItem {
	@ApiModelProperty(value = "A unique key for each orderItem")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderItemId;


	private Long productId;
	@Transient

	private Product product;

	@ApiModelProperty(value = "quantity for each orderitem")
	@NotNull
	@Column(unique=true)
	private int quantity;

	@ApiModelProperty(value = "price for each orderitem")
	@NotNull
	@Column(unique=true)
	private double price;



	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orderId")
	private Order order;



	public OrderItem() {
		super();
	}

	public OrderItem(Long orderItemId, Long productId, Product product,  int quantity,  double price,
			Order order) {
		super();
		this.orderItemId = orderItemId;
		this.productId = productId;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.order = order;
	}

	public OrderItem(Long orderItemId, Long productId, Product product, @NotNull int quantity, @NotNull double price) {
		super();
		this.orderItemId = orderItemId;
		this.productId = productId;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}




}
