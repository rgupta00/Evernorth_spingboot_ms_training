package com.productapp.controller;

import com.productapp.dto.ProductDto;
import com.productapp.entites.Product;
import com.productapp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // vs @Controller
public class ProductController {
    private  ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //ResponseEntity =data + status code

    //get all products
    @GetMapping(path = "products")
    public ResponseEntity<List<ProductDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }
    //get by id
    @GetMapping(path = "products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable int id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
    //adding a product
    @PostMapping(path = "products")
    public ResponseEntity<ProductDto> addProduct( @RequestBody @Valid Product product){
       // return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
        return null;
    }

    //delete
    @DeleteMapping(path = "products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name = "id") int id){
         productService.deleteProduct(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //update
    @PutMapping(path = "products/{id}")
    public ResponseEntity<ProductDto>  updateProduct(@PathVariable(name = "id") int id, @RequestBody Product product){
        return null;
        //return ResponseEntity.ok(productService.updateProduct(id, product));
    }

}
