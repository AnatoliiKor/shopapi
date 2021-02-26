package com.kor.shopapi.controller;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.domain.Cart;
import com.kor.shopapi.domain.CartItem;
import com.kor.shopapi.domain.User;
import com.kor.shopapi.services.BikeService;
import com.kor.shopapi.services.CartItemService;
import com.kor.shopapi.services.CartService;
import com.kor.shopapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private BikeService bikeService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/shop")
    public String main(@RequestParam(required = false) String filter, Model model) {
//        TODO images on start
        List<Bike> bikes;
        if (filter != null && !filter.isEmpty()) {
            bikes = bikeService.findByName(filter);
        } else {
            bikes = bikeService.findAll();
        }
        model.addAttribute("bikes", bikes);
        model.addAttribute("filter", filter);
        return "main_page";
    }



    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal User user, @RequestParam(required = false) String filter, Model model) {
        Iterable<User> users = userService.findAll();
        List<Bike> bikes;
        if (filter != null && !filter.isEmpty()) {
            bikes = bikeService.findByName(filter);
        } else {
            bikes = bikeService.findAll();
        }
        model.addAttribute("bikes", bikes);
        model.addAttribute("user_name", user.getUsername());
        model.addAttribute("users", users);
        model.addAttribute("bikes", bikes);
        model.addAttribute("filter", filter);
        return "admin";
    }

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal User user,
                          Model model) {
//        User user = userService.findById(client.getId());
//        TODO repeat the carts as items
        List<Cart> carts = user.getCarts();
        model.addAttribute("carts", carts);
        List<CartItem> cartItems = cartItemService.findAll();
        model.addAttribute("cartItems", cartItems);
        return "profile";
    }

//    @GetMapping("/sortByBrand")
//    public String sortByBrand(Model model) {
//        List<Bike> bikes = bikeService.sortByBrand();
//        model.addAttribute("bikes", bikes);
//        return "redirect: shop";
//    }

}