package com.kor.shopapi.controller;

import com.kor.shopapi.domain.Role;
import com.kor.shopapi.domain.User;
import com.kor.shopapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(@RequestParam Map<String, String> form, @RequestParam("userId") User user) {
        userService.save(user, form);
        return "redirect:/user";
    }

    @GetMapping("/password")
    public String passwordEditForm(@AuthenticationPrincipal User user, Model model) {
        user = userService.findByUsername(user.getUsername());
        model.addAttribute("user", user);
        return "userPassword";
    }
    @PostMapping("/password")
    public String setPassword(@RequestParam("userId") User user, String userPassword) {
        if (!userPassword.equals("") && !user.getPassword().equals(userPassword)) {
            user.setPassword(userPassword);
            userService.setPassword(user);
        }

        return "redirect:/user/password";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam String id) {
        userService.deleteUser(Long.valueOf(id));
        return "redirect:/user";
    }

}
