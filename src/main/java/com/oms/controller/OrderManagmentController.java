package com.oms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.model.OrderItem;
import com.oms.service.OrderItemService;

@RestController
public class OrderManagmentController {

	@Autowired
	OrderItemService orderItemService;

	@PostMapping("/oms/orderitems")
	public ResponseEntity<OrderItem> createOrderItem(@Valid @RequestBody  OrderItem orderItem) {
		orderItemService.createOrderItem(orderItem);
		return new ResponseEntity<>(orderItem,HttpStatus.CREATED) ;
	}

	@GetMapping("/oms/orderitems/{id}")
	public ResponseEntity<OrderItem> retriveOrderItem(@PathVariable int id) {
		OrderItem orderItem = orderItemService.retriveOrderItem(id);
		return new ResponseEntity<>(orderItem,HttpStatus.OK) ;
	}
	
	@PostMapping("/oms/order/{orderId}/items")
	public ResponseEntity<List<OrderItem>> createOrderItems(@RequestBody  List<OrderItem> orderItems ,@PathVariable int orderId){
		orderItemService.createOrderItems(orderItems,orderId);
		return new ResponseEntity<>(orderItems,HttpStatus.CREATED) ;
	}
	
	@GetMapping("/oms/order/{orderId}/items")
	public ResponseEntity<List<OrderItem>> retriveOrderItems(@PathVariable int orderId) {
		List<OrderItem> orderItems = orderItemService.retriveOrderItems(orderId);
		return new ResponseEntity<>(orderItems,HttpStatus.OK) ;
	}

	

}
