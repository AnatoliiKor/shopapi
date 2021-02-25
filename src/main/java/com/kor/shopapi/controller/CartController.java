package com.kor.shopapi.controller;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.domain.CartItem;
import com.kor.shopapi.domain.Cart;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    UserService userService;
    @Autowired
    CartItemService cartItemService;
    @Autowired
    CartService cartService;
    @Autowired
    BikeService bikeService;

    @PostMapping("/buy")
    public String buy(@RequestParam String id,
                      HttpSession httpSession) {
        Bike bike = bikeService.findById(Long.valueOf(id));
        int price = bike.getPrice();
        List<CartItem> cartItems = (List<CartItem>) httpSession.getAttribute("cartItems");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }
        CartItem cartItem = new CartItem(bike, price);
        cartItems.add(cartItem);
        httpSession.setAttribute("cartItems", cartItems);
        return "redirect:cart";
    }

    @GetMapping("/cart")
    public String cartItemList(@AuthenticationPrincipal User user,
                               HttpSession httpSession,
                               Model model) {
        List<CartItem> cartItems = (List<CartItem>) httpSession.getAttribute("cartItems");
        int total = 0;
        if (cartItems != null) {
            for (CartItem c : cartItems) {
                total += c.getBike().getPrice();
            }
        }
            model.addAttribute("user_name", user.getUsername());
            model.addAttribute("total", total);
            model.addAttribute("cartItems", cartItems);
            httpSession.setAttribute("total", total);
            if (total == 0) httpSession.setAttribute("cartItems", null);
        return "cart";
    }

    @PostMapping("/deletecartitem")
    public String deleteById(@RequestParam String id,
                             HttpSession httpSession) {
        List<CartItem> cartItems = (List<CartItem>) httpSession.getAttribute("cartItems");
        for (CartItem c : cartItems) {
            if (c.getBike().getId() == Long.valueOf(id)) {cartItems.remove(c);return "redirect:cart";}
        }
        httpSession.setAttribute("cartItems", cartItems);
        return "redirect:cart";
    }

    @PostMapping("/checkout")
    public String buy(@AuthenticationPrincipal User client,
                      HttpSession httpSession) {
        List<CartItem> cartItems = (List<CartItem>) httpSession.getAttribute("cartItems");
        if (cartItems == null) return "redirect:shop";
        User user = userService.findById(client.getId());
        Cart cart = new Cart(user, cartItems, httpSession.getAttribute("total"));
        cartService.save(cart);
        for(CartItem c : cartItems) {
            c.setCart(cart);
            cartItemService.save(c);
        }
        httpSession.setAttribute("cartItems", null);
        return "redirect:cart";
    }
}
