package com.codegym.controller;

import com.codegym.dto.ProductDto;
import com.codegym.model.Product;
import com.codegym.model.ProductType;
import com.codegym.service.IProductService;
import com.codegym.service.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
                          @RequestParam Optional<String> name,
                          @RequestParam Optional<String> type){
        String nameVal = name.orElse("");
        String typeVal = type.orElse("");
        Page<Product> productList = null;
        if (typeVal.equals("")){
            productList=this.iProductService.findAllByProductNameContaining(nameVal,pageable);
        } else {
            productList=this.iProductService.findAllByProductNameContainingAndProduct_Type_Id(nameVal,typeVal,pageable);
        }

        model.addAttribute("productList",productList);
        model.addAttribute("productTypeList", this.iProductTypeService.findAll());
        model.addAttribute("nameVal", nameVal);
        model.addAttribute("typeVal", typeVal);
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model){
        model.addAttribute("productDto",new ProductDto());
        model.addAttribute("productTypeList", this.iProductTypeService.findAll());
        return "create";
    }
//
    @PostMapping(value = "/create")
    public String createProduct(@ModelAttribute @Validated ProductDto productDto,
                                BindingResult bindingResult,
                                Model model){
        new ProductDto().validate(productDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("productTypeList", this.iProductTypeService.findAll());
            return "create";
        } else {
            Product product=new Product();
            BeanUtils.copyProperties(productDto,product);
            this.iProductService.createProduct(product);
        }
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
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(this.iProductService.detail(productId),productDto);
        model.addAttribute("productDto", productDto);
        model.addAttribute("productTypeList", this.iProductTypeService.findAll());
        return "update";
    }

    @PostMapping(value = "/update")
    public String updateProduct(@ModelAttribute @Validated ProductDto productDto,
                                BindingResult bindingResult,
                                Model model){
        new ProductDto().validate(productDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("productTypeList", this.iProductTypeService.findAll());
            return "create";
        } else {
            Product product=new Product();
            BeanUtils.copyProperties(productDto,product);
            this.iProductService.createProduct(product);
        }
        return "redirect:/list";
    }

}
