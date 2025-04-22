package com.productapp.service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repo.Product;
import com.productapp.repo.ProductDao;
import com.productapp.repo.ProductDaoImplUsingJdbc;
import com.productapp.repo.ProductDaoImplUsingMap;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//pull vs push
@Service
public class ProductServiceImpl implements ProductService{

    private  ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products= productDao.getAll();
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        Product product= productDao.getProductById(productId);
        if(product==null){
            throw new ProductNotFoundException("product with id "+ productId +" is not found");
        }
        return product;
    }

    @Override
    public Product addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        return productDao.updateProduct(productId,product );
    }

    @Override
    public Product deleteProduct(int productId) {
        return productDao.deleteProduct(productId);
    }
}
