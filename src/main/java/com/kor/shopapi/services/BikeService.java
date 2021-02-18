package com.kor.shopapi.services;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.domain.Product;
import com.kor.shopapi.repository.BikeRepository;
import com.kor.shopapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public Bike save(Bike bike) {
        return bikeRepository.save(bike);
    }
//    public Product save(Product product) {
//        return productRepository.save(product);
//    }
//
    public List<Bike> findAll() {
        return bikeRepository.findAll();
    }

    public List<Bike> findByName(String name) {
        return bikeRepository.findByName(name);
    }
//
//    public void deleteById(Integer id) {
//        productRepository.deleteById(id);
//    }

    public Bike findById(Long id) {
        Bike bike = bikeRepository.findById(id).get();
        return bike;
    }
}
