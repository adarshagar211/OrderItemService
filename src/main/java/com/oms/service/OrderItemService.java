package com.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.exception.OrderItemNotFoundException;
import com.oms.model.OrderItem;
import com.oms.repository.OrderItemRepository;

@Service
public class OrderItemService {
		
	@Autowired
	OrderItemRepository orderItemRespository;
	
	 
	public void createOrderItem( OrderItem orderItem) {
		orderItemRespository.save(orderItem);
	}
	
	public void createOrderItems(List<OrderItem> orderItems,int orderId) {
		orderItems.forEach(orderItem -> orderItem.setOrderId(orderId));
		orderItemRespository.saveAll(orderItems);
	}

	public OrderItem retriveOrderItem(int id) {
        return orderItemRespository.findById(id).orElseThrow(OrderItemNotFoundException::new);
	}
	
	public List<OrderItem> retriveOrderItems(int orderId) {
        return orderItemRespository.findAllByOrderId(orderId);
	}
	

}
