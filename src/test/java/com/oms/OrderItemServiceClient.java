package com.oms;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.oms.model.OrderItem;

@FeignClient(value = "orderItemServiceClient", url = "http://localhost:8080/")
public interface OrderItemServiceClient {
 	
	@PostMapping("/oms/orderitems")
	public ResponseEntity<OrderItem> createOrderItem(@RequestBody  OrderItem orderItem);

	@GetMapping("/oms/orderitems/{id}")
	public ResponseEntity<OrderItem> retriveOrderItem(@PathVariable int id);

}
