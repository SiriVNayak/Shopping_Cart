package com.shoppingcart.OrderService.service;

import com.shoppingcart.OrderService.model.OrderRequest;

public interface OrderService {

	long placeOrder(OrderRequest orderRequest);

}
