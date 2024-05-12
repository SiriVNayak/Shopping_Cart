package com.shoppingcart.ProductService.service;

import com.shoppingcart.ProductService.model.ProductRequest;
import com.shoppingcart.ProductService.model.ProductResponse;

public interface ProductService {

	long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(long productId);
	
}
