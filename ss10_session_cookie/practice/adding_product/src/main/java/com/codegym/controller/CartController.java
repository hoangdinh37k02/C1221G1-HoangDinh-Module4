package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {
//    @RequestMapping
//    public ModelAndView ShowCart(@SessionAttribute(name = "cart", required = false) CartDto cartDto){
//        return new ModelAndView("cart/list", "cart", cartDto);
//    }
    @GetMapping
    public String show(@SessionAttribute(name = "cart", required = false)CartDto cartDto,
                       Model model){
        model.addAttribute("cart", cartDto);
        return "cart/list";
    }


//    @ModelAttribute("cart")
//    public Cart setupCart(){
//        return new Cart();
//    }
//
//    @GetMapping("/shopping-cart")
//    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
//        ModelAndView modelAndView = new ModelAndView("cart");
//        modelAndView.addObject("cart",cart);
//        return modelAndView;
//    }
    }
