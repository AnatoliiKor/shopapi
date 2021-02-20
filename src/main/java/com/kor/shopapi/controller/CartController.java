package com.kor.shopapi.controller;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.domain.CartItem;
import com.kor.shopapi.domain.Cart;
import com.kor.shopapi.domain.User;
import com.kor.shopapi.repository.CartItemRepository;
import com.kor.shopapi.repository.CartRepository;
import com.kor.shopapi.repository.UserRepository;
import com.kor.shopapi.services.BikeService;
import com.kor.shopapi.services.CartItemService;
import com.kor.shopapi.services.CartService;
import com.kor.shopapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    UserService userService;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartItemService cartItemService;
    @Autowired
    CartService cartService;
    @Autowired
    BikeService bikeService;

    @PostMapping("/buy")
    public String buy(@AuthenticationPrincipal User user, @RequestParam String id,
                      @RequestParam Integer price, Model model) {
        Bike bike = bikeService.findById(Long.valueOf(id));
        User userFromDB = userService.findById(user.getId());
        Cart cart = new Cart(userFromDB);
        cartService.save(cart);
        CartItem cartItem = new CartItem(bike, price, cart);
        cartItemService.save(cartItem);
        return "redirect:cart";
    }

    @GetMapping("/cart")
    public String cartItemList(@AuthenticationPrincipal User user, Model model) {
        List<CartItem> cartItems = cartItemService.findAll();
        model.addAttribute("user_name", user.getUsername());
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/deletecartitem")
    public String deleteById(@RequestParam String id, Model model) {
        cartItemService.deleteById(Long.valueOf(id));
        return "redirect:cart";
    }





    @PostMapping("/checkout")
    public String buy(@AuthenticationPrincipal User client, Model model) {
        List<Long> clients = new ArrayList<>();
        clients.add(client.getId());
        System.out.println("client " + clients.toString());
//        List<CartItem> cartItems = cartItemService.findAllByClientId(clients);
        List<CartItem> cartItems = cartItemService.findAll();
        System.out.println(cartItems.toString());
        Cart cart = new Cart(client, cartItems);
        cartService.save(cart);
        return "redirect:cart";
    }
}
