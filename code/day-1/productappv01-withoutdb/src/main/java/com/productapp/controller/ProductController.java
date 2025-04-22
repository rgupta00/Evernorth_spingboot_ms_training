package com.productapp.controller;

import com.productapp.repo.Product;
import com.productapp.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // vs @Controller
public class ProductController {
    private  ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //get all products
    @GetMapping(path = "products")
    public List<Product> getAll(){
        return productService.getAll();
    }
    //get by id
    @GetMapping(path = "products/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }
    //adding a product
    @PostMapping(path = "products")
    public Product addProduct( @RequestBody Product product){
        return productService.addProduct(product);
    }

    //delete
    @DeleteMapping(path = "products/{id}")
    public Product deleteProduct(@PathVariable(name = "id") int id){
        return productService.deleteProduct(id);
    }
    //update
    @PutMapping(path = "products/{id}")
    public Product updateProduct(@PathVariable(name = "id") int id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

}
