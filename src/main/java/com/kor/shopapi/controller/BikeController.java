package com.kor.shopapi.controller;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.domain.Role;
import com.kor.shopapi.domain.User;
import com.kor.shopapi.repository.BikeRepository;
import com.kor.shopapi.repository.UserRepository;
import com.kor.shopapi.services.BikeService;
import com.kor.shopapi.services.CartItemService;
import com.kor.shopapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class BikeController {

    @Autowired
    private UserService userService;
    @Autowired
    private BikeService bikeService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute(userService.findAll());
        return "userList";
    }

    @GetMapping("/newbike")
    public String newBike() {
        return "newbike";
    }
    
    @PostMapping("/add")
    public String add(@ModelAttribute("bike") Bike bike,
                      @RequestParam("file")MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));
            bike.setFilename(resultFilename);
        }
        bikeService.save(bike);
        return "redirect:admin";
    }

    @PostMapping("/delete")
    public String deleteById(@RequestParam String id, Model model) {
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
//            @RequestParam String category,
//            @RequestParam String brand,
//            @RequestParam String colour,
            @RequestParam String description,
            @RequestParam String price,
            @RequestParam String amount,
            @RequestParam("bikeId") Bike bike,
            @RequestParam("file")MultipartFile file) throws IOException {

        if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + file.getOriginalFilename();

                file.transferTo(new File(uploadPath + "/" + resultFilename));
                bike.setFilename(resultFilename);
            }
        bike.setName(name);
//        bike.setCategory(category);
//        bike.setBrand(brand);
//        bike.setColour(colour);
        bike.setDescription(description);
        bike.setPrice(Integer.valueOf(price));
        bike.setAmount(Integer.valueOf(amount));


        bikeService.save(bike);
        return "redirect:/admin";
    }


}
