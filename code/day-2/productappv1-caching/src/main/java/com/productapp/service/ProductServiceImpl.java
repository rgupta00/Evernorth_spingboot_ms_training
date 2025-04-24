package com.productapp.service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//pull vs push
@Service
@AllArgsConstructor
@Log4j2
@Transactional
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;

    @Cacheable(value="products")
    @Override
    public List<Product> getAll() {
        log.info("Getting all products is called");
        List<Product> products= productRepo.findAll();
        return products;
    }
    @Cacheable(value="products", key = "#id")
    @Override
    public Product getProductById(int id) {
        Product product= productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return product;
    }

    @CachePut(value="products", key="#result.id")
    @Override
    public Product addProduct(Product product) {
         productRepo.save(product);
         return product;
    }

    @CachePut(value="products", key="#result.id")
    @Override
    public Product updateProduct(int id, Product product) {
        Product productToUpdate= getProductById(id);
        productToUpdate.setPrice(product.getPrice());
        productRepo.save(productToUpdate);
        return  productToUpdate;
    }

    @CacheEvict(value="products", key="#id")
    @Override
    public Product deleteProduct(int id) {
        Product productToDelete= getProductById(id);
         productRepo.delete(productToDelete);
         return productToDelete;
    }
    @CacheEvict(value="products", allEntries=true)
    @Override
    public void removeCache() {}
}
