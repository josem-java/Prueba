package com.example.demo.service;

import com.example.demo.model.Product;
import java.util.List;

public interface ProductService {
    Product save(Product product);
    Product put(Product product, Long id);
    void delete(Long id);
    Product get(Long id);
    List<Product> list();
}
