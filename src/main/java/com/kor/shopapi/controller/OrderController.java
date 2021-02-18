package com.kor.shopapi.controller;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.domain.CartItem;
import com.kor.shopapi.domain.Order;
import com.kor.shopapi.domain.User;
import com.kor.shopapi.repository.CartItemRepository;
import com.kor.shopapi.repository.OrderRepository;
import com.kor.shopapi.services.CartItemService;
import com.kor.shopapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CartItemService cartItemService;
    @Autowired
    OrderService orderService;

    @PostMapping("/checkout")
    public String buy(@AuthenticationPrincipal User client, Model model) {
        List<Long> clients = new ArrayList<>();
        clients.add(client.getId());
        System.out.println("client " + clients.toString());
//        List<CartItem> cartItems = cartItemService.findAllByClientId(clients);
        List<CartItem> cartItems = cartItemService.findAll();
        System.out.println(cartItems.toString());
        Order order = new Order(client, cartItems);
        orderService.save(order);
        return "redirect:cart";
    }
}
