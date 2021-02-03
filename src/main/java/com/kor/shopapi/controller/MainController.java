package com.kor.shopapi.controller;

import com.kor.shopapi.domain.Product;
import com.kor.shopapi.repository.ProductRepository;
import com.kor.shopapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }
//    @GetMapping("/logout")
//    public String logout(Map<String, Object> model) {
//        return "greeting";
//    }

    @GetMapping("/shop")
    public String main(Map<String, Object> model) {
        Iterable<Product> products = productService.findAll();
        model.put("products", products);
        return "main_page";
    }

    @PostMapping("/add")
    public String main(@RequestParam String name,@RequestParam Integer price,
                       @RequestParam Integer amount,@RequestParam String description,
                       Map<String, Object> model) {
        Product product = new Product(name, price,amount,description);
        productService.save(product);
        return "redirect:shop";
    }

    @PostMapping("/filter")
    public String filter (@RequestParam String filter, Map<String, Object> model) {
        Iterable<Product> products;
        if (filter != null && !filter.isEmpty()) {
            products = productService.findByName(filter);
            model.put("products", products);
            return "main_page";
        } else {
            return "redirect:shop";
        }
    }
    @PostMapping("/delete")
    public String deleteById (@RequestParam String id, Map<String, Object> model) {
        productService.deleteById(Integer.valueOf(id));
        return "redirect:shop";
    }
    @PostMapping("/edit")
    public String editById (@RequestParam String id, @RequestParam String name,@RequestParam Integer price,
                            @RequestParam Integer amount, Map<String, Object> model) {
        String description = "";
        Product product = new Product(name, price,amount,description);
        productService.save(product);
        return "redirect:shop";
    }
}