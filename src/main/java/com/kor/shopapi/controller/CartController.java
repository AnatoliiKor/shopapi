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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
    public String cartItemList(HttpSession httpSession,
                               Model model) {
        List<CartItem> cartItems = (List<CartItem>) httpSession.getAttribute("cartItems");
        int total = 0;
        if (cartItems != null) {
            for (CartItem c : cartItems) {
                total += c.getBike().getPrice();
            }
        }
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
            if (c.getBike().getId() == Long.valueOf(id)) {
                cartItems.remove(c);
                return "redirect:cart";
            }
        }
        httpSession.setAttribute("cartItems", cartItems);
        return "redirect:cart";
    }

    @PostMapping("/checkout")
    public String buy(HttpServletRequest httpServletRequest,
                      HttpSession httpSession) {
        List<CartItem> cartItems = (List<CartItem>) httpSession.getAttribute("cartItems");
        if (cartItems == null) return "redirect:shop";
        User user = userService.findByUsername(httpServletRequest.getRemoteUser());
        Cart cart = new Cart(user, cartItems, httpSession.getAttribute("total"));
        cartService.save(cart);
        for (CartItem c : cartItems) {
            c.setCart(cart);
            cartItemService.save(c);
        }
        httpSession.setAttribute("cartItems", null);
        return "redirect:cart";
    }


    @GetMapping("/show/{cart}")
    public String orderShow(@PathVariable Cart cart, Model model) {
        List<CartItem> cartItems = cart.getCartItems();
        if (cartItems == null) return "redirect:shop";
        model.addAttribute("cart", cart);
        model.addAttribute("cartItems", cartItems);
        return "userOrder";
    }

    @PostMapping("/statusChange/{cart}")
    public String orderStatusChange(@PathVariable Cart cart, @RequestParam String status) {
//        User user = cart.getUser();
        cart.setStatus(status);
        cartService.save(cart);
//        return "/user/orders/"+user.getId(); TODO
        return "userOrder";
    }

    @GetMapping("/allCarts")
    public String showAllCarts(@RequestParam (required = false) String status, Model model) {
        List<Cart> carts;
        if (status !=null) {
            carts = cartService.findByStatus(status);
        } else {carts = cartService.findAll();}
        model.addAttribute("carts", carts);
        return "allCarts";
    }

}
