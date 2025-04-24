package com.products.service;

import com.products.dto.ProductDto;
import com.products.entities.Product;
import com.products.repo.ProductRepo;
import com.products.util.ConvertUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepository;
    @Override
    public ProductDto createProduct(ProductDto productRequest) {
        Product product= ConvertUtil.toProduct(productRequest);
        productRepository.save(product);
        return ConvertUtil.toProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ConvertUtil::toProductDto).toList();
    }
}