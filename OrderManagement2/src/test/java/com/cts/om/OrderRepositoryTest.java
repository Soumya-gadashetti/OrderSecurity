//package com.cts.om;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.cts.om.entities.Order;
//import com.cts.om.entities.OrderItem;
//import com.cts.om.entities.Product;
//import com.cts.om.repository.OrderRepository;
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class OrderRepositoryTest {
//	
//	@MockBean
//	private OrderRepository repo;
//	
//	@Test
//	public void findByTest() {
//		
//		@SuppressWarnings("unchecked")
//		Order order=new Order(1l,"1997-01-03",800.00,(List<OrderItem>)
//				new OrderItem(1l,1l,new Product(1l,"Phone","qwer",800.00),8,400.00));
//		when(repo.findById(1l)).thenReturn(Optional.of(order));
//		Optional<Order> o=repo.findById(1l);
//		assertEquals(order, o);
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Test
//	public void findAllTest() {
//		List<Order> order=new ArrayList<Order>();
//		order.add(new Order(1l,"1997-01-03",800.00,(List<OrderItem>)
//				new OrderItem(1l,1l,new Product(1l,"Phone","qwer",800.00),8,400.00)));
//		when(repo.findAll()).thenReturn(order);
//		@SuppressWarnings("unused")
//		List<?> result=(List<?>) repo.findAll();
//		verify(repo).findAll();
//	}
//	
//}
