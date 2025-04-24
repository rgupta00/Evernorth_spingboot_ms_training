package com.products.service;

import com.products.dto.ProductDto;

import java.util.List;

public interface ProductService{
	public ProductDto createProduct(ProductDto productRequest);
	public List<ProductDto> getAllProducts();
}
