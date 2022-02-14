package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> get(){
        List<Product> productList = productService.list();
        return ResponseEntity.ok().body(productList);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product productSaved = productService.save(product);
        return ResponseEntity.ok().body(productSaved);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> put(@PathVariable("id") Long id, @RequestBody Product product){
        Product productUpdated = productService.put(product,id);
        return ResponseEntity.ok().body(productUpdated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") Long id) {
            Product product = productService.get(id);
            productService.delete(id);
            return ResponseEntity.ok().body(product);
    }
}
