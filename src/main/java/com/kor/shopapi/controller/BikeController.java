package com.kor.shopapi.controller;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.domain.CartItem;
import com.kor.shopapi.domain.User;
import com.kor.shopapi.repository.BikeRepository;
import com.kor.shopapi.repository.UserRepository;
import com.kor.shopapi.services.BikeService;
import com.kor.shopapi.services.CartItemService;
import com.kor.shopapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BikeController {
    @Autowired
    BikeRepository bikeRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BikeService bikeService;
    @Autowired
    private CartItemService cartItemService;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute(userService.findAll());
        return "userList";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam String category,
            @RequestParam String brand,
            @RequestParam String name,
            @RequestParam String colour,
            @RequestParam String description,
            @RequestParam Integer price,
            @RequestParam Integer amount,
            Model model) {
        Bike bike = new Bike.Builder()
                .withCategory(category)
                .withBrand(brand)
                .withName(name)
                .withColour(colour)
                .withDescription(description)
                .withPrice(price)
                .withAmount(amount)
                .build();
        bikeService.save(bike);
        return "redirect:admin";
    }

//    @PostMapping("/buy")
//    public String buy(@AuthenticationPrincipal User user, @RequestParam String id,
//                      @RequestParam Integer price, Model model) {
//        Bike bike = bikeService.findById(Long.valueOf(id));
//        CartItem cartItem = new CartItem(bike, 1, price, user);
//        cartItemService.save(cartItem);
//        return "redirect:cart";
//    }
//
//    @GetMapping("/cart")
//    public String cartItemList(@AuthenticationPrincipal User user, Model model) {
//        List<CartItem> cartItems = cartItemService.findAll();
//        model.addAttribute("user_name", user.getUsername());
//        model.addAttribute("cartItems", cartItems);
//        return "cart";
//    }
//
//    @PostMapping("/deletecartitem")
//    public String deleteById(@RequestParam String id, Model model) {
//        cartItemService.deleteById(Long.valueOf(id));
//        return "redirect:cart";
//    }
//
//    @PostMapping("/edit")
//    public String editById(@AuthenticationPrincipal User user,
//                           @RequestParam String id,
//                           @RequestParam String name,
//                           @RequestParam Integer price,
//                           @RequestParam Integer amount, Map<String, Object> model) {
//        String description = "";
//        Product product = new Product(name, price, amount, description, user);
//        productService.save(product);
//        return "redirect:admin";
//    }






















}
