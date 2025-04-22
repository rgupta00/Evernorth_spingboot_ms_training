package com.productapp.service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
//pull vs push
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;


    @Override
    public List<Product> getAll() {
        List<Product> products= productRepo.findAll();
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        Product product= productRepo.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return product;
    }

    @Override
    public Product addProduct(Product product) {
         productRepo.save(product);
         return product;
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        Product productToUpdate= getProductById(productId);
        productToUpdate.setPrice(product.getPrice());
        productRepo.save(productToUpdate);
        return  productToUpdate;
    }

    @Override
    public Product deleteProduct(int productId) {
        Product productToDelete= getProductById(productId);
         productRepo.delete(productToDelete);
         return productToDelete;
    }
}
