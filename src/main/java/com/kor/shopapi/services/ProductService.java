package com.kor.shopapi.services;

import com.kor.shopapi.domain.Product;
import com.kor.shopapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    public List<Product> findByName(String name) {
        return (List<Product>) productRepository.findByName(name);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
