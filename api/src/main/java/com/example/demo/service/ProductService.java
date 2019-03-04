package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Product;
import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());

        return repository.save(product);
    }

    public Product findById(Long id) {
        Optional<Product> product = repository.findById(id);
        return product.orElse(null);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public void update(Long id, ProductDto productDto) {
        Product product = this.findById(id);

        if (product != null) {
            product.setName(productDto.getName());
            repository.save(product);
        }
    }

    public void delete(Long id) {
        Product product = this.findById(id);

        if (product != null) {
            repository.delete(product);
        }
    }
}