package com.shoppingcart.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.OrderService.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
