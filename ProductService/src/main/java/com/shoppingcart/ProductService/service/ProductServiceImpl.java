package com.shoppingcart.ProductService.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.ProductService.entity.Product;
import com.shoppingcart.ProductService.exception.ProductServiceCustomException;
import com.shoppingcart.ProductService.model.ProductRequest;
import com.shoppingcart.ProductService.model.ProductResponse;
import com.shoppingcart.ProductService.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public long addProduct(ProductRequest productRequest) {
		log.info(">>> Adding Product...");
		Product product = Product.builder().productName(productRequest.getName()).price(productRequest.getPrice())
				.quantity(productRequest.getQuantity()).build();

		productRepository.save(product);
		log.info(">>> Product Created.");
		return product.getProductId();
	}

	@Override
	public ProductResponse getProductById(long productId) {
		log.info(">>> Started Getting Data fot Product Id : " + productId);
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductServiceCustomException("Product with Id : " + productId + " doesn't exist", "PRODUCT_NOT_FOUND"));
		
		ProductResponse productResponse = new ProductResponse();
		BeanUtils.copyProperties(product, productResponse);

		log.info(">>> Data Fetching Done. ");

		return productResponse;
	}

}
