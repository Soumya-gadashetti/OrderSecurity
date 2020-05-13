package com.cts.om;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cts.om.entities.Order;
import com.cts.om.entities.OrderItem;
import com.cts.om.entities.Product;
import com.cts.om.repository.OrderRepository;
import com.cts.om.service.OrderService;


@RunWith(MockitoJUnitRunner.Silent.class)
public class OrderServiceTest {
	@Mock
	private OrderRepository repo;
	@InjectMocks
	private OrderService service;

	@Test
	public void addOrdersTest() {

		Order order=new Order();
		order.setOrderId(1L);
		order.setOrderDate("1997-08-01");
		order.setOrderPrice(800.00);		
		Mockito.when(repo.save(order)).thenReturn(order);
		assertSame(1L,service.addOrder(order).getOrderId());
	}

	@SuppressWarnings("static-access")
	@Test
	public void getOrderById() {
		@SuppressWarnings("unchecked")
		OrderItem orderItem1=new OrderItem(1L,1L,new Product(1L,"Phone","qwer",800.00),8,400.00);
		List<OrderItem> orderItem=new ArrayList<OrderItem>();
		orderItem.add(orderItem1);

		@SuppressWarnings("unchecked")

		Order order1=new Order(1L,"1997-01-03",800.00,orderItem);
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(order1));
		assertSame(1L,service.getOrderById(((Order) order1).getOrderId()).getOrderId());
	}

}
