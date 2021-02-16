package com.kor.shopapi.controller;

import com.kor.shopapi.repository.CartItemRepository;
import com.kor.shopapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderController {
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    OrderRepository orderRepository;
}
