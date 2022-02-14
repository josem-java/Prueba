package com.example.demo.service;

import com.example.demo.constant.ProductState;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product put(Product productUpdate, Long id) {
        Product product = this.get(id);
        product.setPrice(productUpdate.getPrice());
        product.setName(productUpdate.getName());
        product.setImage(productUpdate.getImage());
        return this.save(product);
    }

    @Override
    public void delete(Long id) {
        assert id != null;
        Product product = this.get(id);
        if(product != null){
            product.setState(ProductState.INACTIVE);
            this.save(product);
        }
    }

    @Override
    public Product get(Long id) {
        assert id != null;
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public List<Product> list() {
        return productRepository
                .findAll()
                .stream()
                .filter(product -> product.getState() == ProductState.ACTIVE).collect(Collectors.toList());
    }
}
