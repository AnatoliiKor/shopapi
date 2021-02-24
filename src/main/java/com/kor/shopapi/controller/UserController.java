package com.kor.shopapi.controller;

import com.kor.shopapi.domain.Role;
import com.kor.shopapi.domain.User;
import com.kor.shopapi.repository.UserRepository;
import com.kor.shopapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
    public String userSave(
            @RequestParam String username,
            @RequestParam (required = false) String active,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user){

        if (active!=null)  user.setActive(true);
        else user.setActive(false);

        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if(roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userService.save(user);
       return "redirect:/user";
    }

//    @PostMapping("/delete")
//    public String deleteByUserName (@RequestParam String id, Map<String, Object> model) {
//        userService.deleteByUserName(Long.valueOf(id));
//        return "redirect:";
//    }

}
