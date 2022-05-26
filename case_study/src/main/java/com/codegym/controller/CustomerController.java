package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public String getCustomerList(Model model, @PageableDefault(value = 5) Pageable pageable,
                           @RequestParam Optional<String> name, @RequestParam Optional<String> email,
                                  @RequestParam Optional<String> type) {
        String nameVal = name.orElse("");
        String emailVal = email.orElse("");
        String typeVal = type.orElse("");
        Page<Customer> customerPage = null;
        if (typeVal.equals("")){
            customerPage = this.iCustomerService.find1(0,nameVal,emailVal,pageable);
        } else {
            customerPage=this.iCustomerService.find2(0,nameVal,emailVal,typeVal,pageable);

        }
//        model.addAttribute("customer", iCustomerService.findAll(nameVal, pageable));
        model.addAttribute("customer", customerPage);
        model.addAttribute("nameVal", nameVal);
        model.addAttribute("typeVal", typeVal);
        model.addAttribute("emailVal", emailVal);
        model.addAttribute("customerType", this.iCustomerTypeService.findAll());
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
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customerType", this.iCustomerTypeService.findAll());
            return "customer/create";
        } else {
            Customer customer=new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            customer.setCustomerCode("KH-"+getString());
            this.iCustomerService.save(customer);
        }
        redirectAttributes.addFlashAttribute("message", "Creation successful");
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/delete")
    public String deleteProduct(@RequestParam("customerId") int customerId,
                                RedirectAttributes redirectAttributes){
//        this.iCustomerService.deleteCustomer(customerId);
        Customer customer = this.iCustomerService.findById(customerId);
        customer.setStatus(1);
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Deleting successful");
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
                                BindingResult bindingResult, RedirectAttributes redirectAttributes,
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

    public String getString(){
        String result ="";
        for (int i=0; i<4; i++){
            result+=getRandomNumber();
        }
        return result;
    }

    public int getRandomNumber(){
        int number;
        number = (int)Math.round(Math.random()*10);
        return number;
    }
}
