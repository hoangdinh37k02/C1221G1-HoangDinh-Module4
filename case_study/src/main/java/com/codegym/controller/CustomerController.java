package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping({"/list","/"})
    public String getCustomerList(Model model, @PageableDefault(value = 3) Pageable pageable,
                           @RequestParam Optional<String> name) {
        String nameVal = name.orElse("");
        model.addAttribute("customer", iCustomerService.findAll(nameVal, pageable));
        model.addAttribute("nameVal", nameVal);
        return "customer/list";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        model.addAttribute("customerType", this.iCustomerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping(value = "/create")
    public String createProduct(@ModelAttribute @Validated CustomerDto customerDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model){
//        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customerType", this.iCustomerTypeService.findAll());
            return "customer/create";
        } else {
            Customer customer=new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            this.iCustomerService.save(customer);
        }
        redirectAttributes.addFlashAttribute("message", "Creation successful");
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/delete")
    public String deleteProduct(@RequestParam("customerId") int customerId){
        this.iCustomerService.deleteCustomer(customerId);
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/update")
    public String goUpdateForm(@RequestParam("customerId") int customerId, Model model){
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(this.iCustomerService.findById(customerId),customerDto);
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerType", this.iCustomerTypeService.findAll());
        return "customer/update";
    }

    @PostMapping(value = "/update")
    public String updateCustomer(@ModelAttribute @Validated CustomerDto customerDto,
                                BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                Model model){
//        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customerType", this.iCustomerTypeService.findAll());
            return "customer/update";
        } else {
            Customer customer=new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            this.iCustomerService.save(customer);
        }
        redirectAttributes.addFlashAttribute("message", "Updating successful");
        return "redirect:/customer/list";
    }
}
