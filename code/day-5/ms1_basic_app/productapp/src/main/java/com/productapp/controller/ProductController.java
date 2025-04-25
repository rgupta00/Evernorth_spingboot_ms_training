package com.productapp.controller;

import com.productapp.dto.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RefreshScope
@RestController
public class ProductController {
    private ProductService productService;

    @Value("${data.info}")
    private String info;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("info")
    public String info(){
        return info;
    }

    //http://localhost:8082/products?id=1&couponCode=SUP10
    @GetMapping("products")
    public Product getById(@RequestParam int id,@RequestParam String couponCode) {
        return productService.getById(id, couponCode);
    }

}
