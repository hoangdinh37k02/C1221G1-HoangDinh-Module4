package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.ProductType;
import com.codegym.service.IProductService;
import com.codegym.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IProductTypeService iProductTypeService;

    @GetMapping(value = {"/list","/"})
    public String getList(Model model,
                          @PageableDefault(value = 3)Pageable pageable,
                          @RequestParam Optional<String> name){
        String nameVal = name.orElse("");
        model.addAttribute("productList", this.iProductService.findAll(nameVal,null, pageable));
        model.addAttribute("productTypeList", this.iProductTypeService.findAll());
        model.addAttribute("nameVal", nameVal);
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("productTypeList", this.iProductTypeService.findAll());
        return "create";
    }
//
    @PostMapping(value = "/create")
    public String createProduct(@ModelAttribute Product product){
        this.iProductService.createProduct(product);
        return "redirect:/list";
    }
//
    @GetMapping(value = "/delete")
    public String deleteProduct(@RequestParam("productId") int productId){
        this.iProductService.deleteProduct(productId);
        return "redirect:/list";
    }
//
    @GetMapping(value = "/detail")
    public String detailProduct(@RequestParam("productId") int productId, Model model){
        model.addAttribute("product", this.iProductService.detail(productId));
        model.addAttribute("productTypeList", this.iProductTypeService.findAll());
        return "detail";
    }

    @GetMapping(value = "/update")
    public String goUpdateForm(@RequestParam("productId") int productId, Model model){
        model.addAttribute("product", this.iProductService.detail(productId));
        model.addAttribute("productTypeList", this.iProductTypeService.findAll());
        return "update";
    }

    @PostMapping(value = "/update")
    public String updateProduct(@ModelAttribute Product product){
        this.iProductService.updateProduct(product);
        return "redirect:/list";
    }

}
