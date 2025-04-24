package com.productapp.controller;

import com.productapp.repo.Product;
import com.productapp.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }
    //get by id
    @GetMapping(path = "products/{id}")
    @Operation(
            summary = "Get product by ID",
            description = "Returns a single product by its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product found"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Product> getProductById(@PathVariable String id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
    //adding a product
    @PostMapping(path = "products")
    public ResponseEntity<Product> addProduct( @RequestBody @Valid Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
    }

    //delete
    @DeleteMapping(path = "products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name = "id") String id){
         productService.deleteProduct(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //update
    @PutMapping(path = "products/{id}")
    public ResponseEntity<Product>  updateProduct(@PathVariable(name = "id") String id, @RequestBody Product product){
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

}
