//package com.cts.om.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.cts.om.entities.Order;
//import com.cts.om.entities.OrderItem;
//import com.cts.om.entities.Product;
//import com.cts.om.repository.OrderRepository;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//class OrderManagementTest {
//
//	@Autowired
//	private OrderService service;
//	@MockBean
//	private OrderRepository repository;
//	@SuppressWarnings({"unchecked"})
//	@Test
//	public void getOrdersTest() throws Exception{
//		 ((Stream<Order>) when(repository.findAll()).thenReturn((Iterable<Order>) Stream.of(new Order(1L,"1997-08-01",800.00,(List<OrderItem>)
//				new OrderItem(1L,1L,new Product(1L,"Phone","Good",500.00),6,900.00)))))
//		 .collect(Collectors.toList());
//		assertEquals(1,service.getorders());
//}
//
//}
