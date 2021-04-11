package com.kor.shopapi.controller;

import com.kor.shopapi.domain.User;
import com.kor.shopapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){
        if(!userService.addUser(user)) {
            model.addAttribute("message", "User exists! Try another User name");
            return "registration";
        }
        return "redirect:login";
    }

}
