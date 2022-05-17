package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.dto.ProductDto;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto setupCart() {
        return new CartDto();
    }

    @GetMapping({"/shop","/"})
    public String showShop(Model model){
        model.addAttribute("products", productService.findAll());
        return "product/shop";
    }
//    public ModelAndView showShop() {
//        ModelAndView modelAndView = new ModelAndView("/shop");
//        modelAndView.addObject("products", productService.findAll());
//        return modelAndView;
//    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute("cart") CartDto cartDto) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),productDto);
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/sub/{id}")
    public String subToCart(@PathVariable Long id,
                            @SessionAttribute("cart") CartDto cartDto) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),productDto);
            cartDto.subProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         @SessionAttribute("cart") CartDto cartDto){
        Optional<Product> productOptional = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productOptional.get(),productDto);
        cartDto.deleteProduct(productDto);
        return "redirect:/cart";
    }

    @GetMapping("/pay")
    public String pay(@SessionAttribute("cart") CartDto cartDto){
        cartDto.deleteAll();
        return "redirect:/shop";
    }

}
