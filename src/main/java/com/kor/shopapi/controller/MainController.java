package com.kor.shopapi.controller;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.domain.Product;
import com.kor.shopapi.domain.User;
import com.kor.shopapi.services.BikeService;
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

    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/shop")
    public String main(@RequestParam(required = false) String filter, Model model) {
        List<Bike> bikes;
        if (filter != null && !filter.isEmpty()) {
            bikes = bikeService.findByName(filter);
        } else {
            bikes = bikeService.findAll();
        }
        model.addAttribute("bikes", bikes);
//        model.addAttribute("user_name", user.getUsername());
        model.addAttribute("filter", filter);
        return "main_page";
    }

//    @GetMapping("/shop")
//    public String main(@AuthenticationPrincipal User user, @RequestParam(required = false) String filter, Model model) {
//        Iterable<Product> products;
//        if (filter != null && !filter.isEmpty()) {
//            products = productService.findByName(filter);
//        } else {
//            products = productService.findAll();
//        }
//        model.addAttribute("products", products);
//        model.addAttribute("user_name", user.getUsername());
//        model.addAttribute("filter", filter);
//        return "main_page";
//    }

//    @GetMapping("/client")
//    public String client(@AuthenticationPrincipal User user, @RequestParam(required = false) String filter, Model model) {
//        Iterable<Product> products;
//        if (filter != null && !filter.isEmpty()) {
//            products = productService.findByName(filter);
//        } else {
//            products = productService.findAll();
//        }
//        model.addAttribute("products", products);
//        model.addAttribute("user_name", user.getUsername());
//        model.addAttribute("filter", filter);
//        return "client";
//    }

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



}