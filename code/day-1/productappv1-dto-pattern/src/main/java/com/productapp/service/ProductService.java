package com.productapp.service;

import com.productapp.dto.ProductDto;
import com.productapp.entites.Product;

import java.util.List;

public interface ProductService {
    public List<ProductDto> getAll();
    public ProductDto getProductById(int productId);
    public ProductDto addProduct(ProductDto productDto);
    public ProductDto updateProduct(int productId, ProductDto productDto);
    public ProductDto deleteProduct(int productId);
}
