package com.kor.shopapi.controller;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.services.BikeService;
import com.kor.shopapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class BikeController {
    int page = 0;
    String sort = "name";
    String order = "ASC";
    List<Bike> bikes;
    int minPrice;
    int maxPrice;

    @Autowired
    private BikeService bikeService;
//
//    @Value("${upload.path}")
//    private String uploadPath;

    @GetMapping("/shop")
    public String main(@RequestParam(required = false) String filter, Model model) {

        if (filter != null && !filter.isEmpty()) {
            bikes = bikeService.findByName(filter);
            sort = "name";
            order = "ASC";
            minPrice = 0;
            maxPrice = 10000;
        } else if (sort.equals("-")) {
            bikes = bikeService.findByPrice(page, minPrice, maxPrice);
//            sort = "price";
            order = "ASC";
        } else {
            bikes = bikeService.findPage(page, sort, order);
            minPrice = 0;
            maxPrice = 10000;
        }
        model.addAttribute("bikes", bikes);
        model.addAttribute("sort", sort);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);

//        if (order.equals("ASC")) model.addAttribute("order", "ASCENDING"); else
//            model.addAttribute("order", "DESCENDING");
        model.addAttribute("order", order);
        model.addAttribute("page", page);
        model.addAttribute("filter", filter);
        return "main_page";
    }

    @GetMapping("/shop/page")
    public String pageBikes(@RequestParam String p) {
        int page = Integer.valueOf(p);
        if (page >= 0) {
            this.page = page;
        }
        return "redirect:/shop";
    }

    @GetMapping("/shop/sort")
    public String pageSort(@RequestParam String sort, @RequestParam String order) {
        this.page = 0;
        this.sort = sort;
        this.order = order;
        return "redirect:/shop";
    }

    @GetMapping("/shop/price")
    public String findByPrice(@RequestParam int min,
                              @RequestParam int max) {
        sort = "-";
        this.minPrice = min;
        this.maxPrice = max;
        return "redirect:/shop";
    }

    @GetMapping("/newbike")
    public String newBike() {
        return "newbike";
    }

    @PostMapping("/add")
    public String addAndEdit(@ModelAttribute("bike") @Valid Bike bike,
                             BindingResult bindingResult,
                             Model model,
                             @RequestParam("file") MultipartFile file) throws IOException {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorMap);
            model.addAttribute("bike", bike);
            return "newbike";
        } else {
            bikeService.save(bike, file);
        }

        return "redirect:admin";
    }

    @PostMapping("/delete")
    public String deleteById(@RequestParam String id) {
        bikeService.deleteById(Long.valueOf(id));
        return "redirect:admin";
    }

    @GetMapping("/bike/{bike}")
    public String bikeEditForm(@PathVariable Bike bike, Model model) {
        model.addAttribute("bike", bike);
        return "bikeedit";
    }

    @PostMapping("/bike/{bike.id}")
    public String bikeSave(@RequestParam String name,
                           @RequestParam String description,
                           @RequestParam String price,
                           @RequestParam String amount,
                           @RequestParam("bikeId") Bike bike,
                           @RequestParam("file") MultipartFile file) throws IOException {
        bike.setName(name);
        bike.setDescription(description);
        bike.setPrice(Integer.valueOf(price));
        bike.setAmount(Integer.valueOf(amount));
        bikeService.save(bike, file);
        return "redirect:/admin";
    }
}
