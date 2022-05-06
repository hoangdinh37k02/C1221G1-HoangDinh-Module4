package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping(value = {"/list","/"})
    public String getList(Model model){
        model.addAttribute("productList", this.iProductService.showAll());
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createProduct(@ModelAttribute Product product){
        this.iProductService.createProduct(product);
        return "redirect:/list";
    }

    @GetMapping(value = "/delete")
    public String deleteProduct(@RequestParam("productId") int productId){
        this.iProductService.deleteProduct(productId);
        return "redirect:/list";
    }

    @GetMapping(value = "/detail")
    public String detailProduct(@RequestParam("productId") int productId, Model model){
        model.addAttribute("product", this.iProductService.detail(productId));
        return "detail";
    }

    @GetMapping(value = "/update")
    public String goUpdateForm(@RequestParam("productId") int productId, Model model){
        model.addAttribute("product", this.iProductService.detail(productId));
        return "update";
    }

    @PostMapping(value = "/update")
    public String updateProduct(@ModelAttribute Product product){
        this.iProductService.updateProduct(product);
        return "redirect:/list";
    }

    @PostMapping(value = "/search")
    public String searchByName(@RequestParam("name") String name,
                               Model model){
        model.addAttribute("productList", this.iProductService.searchByName(name));
        return "list";
    }
}
