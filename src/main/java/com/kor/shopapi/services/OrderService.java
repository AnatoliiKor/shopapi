package com.kor.shopapi.services;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.domain.CartItem;
import com.kor.shopapi.domain.Order;
import com.kor.shopapi.repository.BikeRepository;
import com.kor.shopapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }
////    public Product save(Product product) {
////        return productRepository.save(product);
////    }
////
//    public List<Bike> findAll() {
//        return (List<Bike>) bikeRepository.findAll();
//    }
//
//    public List<Bike> findByName(String name) {
//        return bikeRepository.findByName(name);
//    }
////
////    public void deleteById(Integer id) {
////        productRepository.deleteById(id);
////    }
//
//    public Bike findById(Long id) {
//        Bike bike = bikeRepository.findById(id).get();
//        return bike;
//    }
}
