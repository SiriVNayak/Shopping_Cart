package com.shoppingcart.OrderService.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.OrderService.entity.Order;
import com.shoppingcart.OrderService.model.OrderRequest;
import com.shoppingcart.OrderService.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Override
	public long placeOrder(OrderRequest orderRequest) {
//		OrderEntity -> Save the Data with Status Order Created
//		Product Service -> Block Product(Reduce the Quantity)
//		Payment Service -> Payment
//		CANCELLED
		log.info("Placing Order Requestr : {}", orderRequest);
		
		Order order = Order.builder()
				.amount(orderRequest.getTotalAmount())
				.orderStatus("CREATED")
				.productId(orderRequest.getProductId())
				.orderDate(Instant.now())
				.quantity(orderRequest.getQuantity())
				.build();
		
		order = orderRepository.save(order);
		log.info(">>> Order Placed Succefully with oRDER iD: {}", order.getId());
		return order.getId();
	}

}
