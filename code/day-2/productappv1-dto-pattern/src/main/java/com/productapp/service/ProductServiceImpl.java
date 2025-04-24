package com.productapp.service;

import com.productapp.dto.ProductDto;
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.entites.Product;
import com.productapp.repo.ProductRepo;
import com.productapp.util.DataConvertor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
//pull vs push
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;

    @Override
    public List<ProductDto> getAll() {
        return productRepo.findAll().stream().map(DataConvertor::convertToProductDto).toList();
    }

    @Override
    public ProductDto getProductById(int productId) {
        Product product= productRepo.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return DataConvertor.convertToProductDto(product);
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        productRepo.save(DataConvertor.convertToProduct(productDto));

        return productDto;
    }

    @Override
    public ProductDto updateProduct(int productId, ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto deleteProduct(int productId) {
        return null;
    }
}
