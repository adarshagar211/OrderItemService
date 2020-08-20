package com.oms;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import com.oms.model.OrderItem;

@SpringBootTest
@EnableFeignClients
class OrderItemApplicationTests {
	
	@Autowired
	OrderItemServiceClient orderItemServiceClient;
	
	@BeforeEach
	public void contextLoads() {
		
		// Prepare Order 
		List<OrderItem> orderItems = new ArrayList<>();
		OrderItem orderItem1 = new OrderItem("Biscuit",2);
		orderItems.add(orderItem1);
	    ResponseEntity<OrderItem> r1 = orderItemServiceClient.createOrderItem(orderItem1);
		
	}

	@Test
	public void test1() {
		ResponseEntity<OrderItem> re = orderItemServiceClient.retriveOrderItem(2);
		Assert.notNull(re.getBody());
	}

}
