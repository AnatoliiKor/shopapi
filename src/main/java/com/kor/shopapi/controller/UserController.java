package com.kor.shopapi.controller;

import com.kor.shopapi.domain.Role;
import com.kor.shopapi.domain.User;
import com.kor.shopapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
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
    public String setPassword(@RequestParam("userId") User user, String userPassword, String oldPassword) {
// TODO
        if (!user.getPassword().equals(passwordEncoder.encode(userPassword)) && !userPassword.equals("")) {
            user.setPassword(userPassword);
            userService.setPassword(user);
        }
        return "redirect:/profile";
    }

    @GetMapping("/email")
    public String emailEditForm(@AuthenticationPrincipal User user, Model model) {
        user = userService.findByUsername(user.getUsername());
        model.addAttribute("user", user);
        return "userEmail";
    }

//    @PostMapping("/email")
//    public String setEmail(@RequestParam("userId") User user, String userEmail) {
//        if (!userEmail.equals("") && !user.getEmail().equals(userEmail)) {
//            user.setEmail(userEmail);
//            userService.setEmail(user);
//        }
//        return "redirect:/profile";
//    }

//    @PostMapping("/email")
//    public String setEmail(@RequestParam("userId")  @Valid User user,
//                           BindingResult bindingResult,
//                           Model model, String userEmail) {
//        if (bindingResult.hasErrors()) {
//            Map<String, String> errorMap = ControllerUtils.getErrors(bindingResult);
//            model.mergeAttributes(errorMap);
//            model.addAttribute("user", user);
//            return "registration";
//        } else {
//            if (!userEmail.equals("") && !user.getEmail().equals(userEmail)) {
//                user.setEmail(userEmail);
//                userService.setEmail(user);
//            }
//            return "redirect:/profile";}
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }



    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteUser(@RequestParam String id) {
        userService.deleteUser(Long.valueOf(id));
        return "redirect:/user";
    }

}
