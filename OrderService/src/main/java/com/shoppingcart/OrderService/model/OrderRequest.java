package com.shoppingcart.OrderService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
	private long productId;
	private long totalAmount;
	private long quantity;
	private PaymentMode paymentMode;
	
}
/*
 * 602 | 2000 | Lenova Tab | 8 | | 603 | 5000 | iPhone | 6
 */
