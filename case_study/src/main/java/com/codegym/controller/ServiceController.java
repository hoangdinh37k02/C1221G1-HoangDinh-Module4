package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.ServiceDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.service.Service;
import com.codegym.service.service.IRentTypeService;
import com.codegym.service.service.IServiceService;
import com.codegym.service.service.IServiceTypeService;
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
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IServiceService iServiceService;
    @Autowired
    private IRentTypeService iRentTypeService;
    @Autowired
    private IServiceTypeService iServiceTypeService;

    @GetMapping({"/list","/"})
    public String getCustomerList(Model model, @PageableDefault(value = 5) Pageable pageable,
                                  @RequestParam Optional<String> name) {
        String nameVal = name.orElse("");
        model.addAttribute("service", iServiceService.findAll(nameVal, pageable));
        model.addAttribute("nameVal", nameVal);
        return "service/list";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model){
        model.addAttribute("serviceDto",new ServiceDto());
        model.addAttribute("rentType", this.iRentTypeService.findAll());
        model.addAttribute("serviceType", this.iServiceTypeService.findAll());
        return "service/create";
    }

    @PostMapping(value = "/create")
    public String createService(@ModelAttribute @Validated ServiceDto serviceDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model){
//        new ServiceDto().validate(serviceDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("rentType", this.iRentTypeService.findAll());
            model.addAttribute("serviceType", this.iServiceTypeService.findAll());
            return "service/create";
        } else {
            Service service=new Service();
            BeanUtils.copyProperties(serviceDto,service);
            service.setServiceCode("DV-"+getString());
            this.iServiceService.save(service);
        }
        redirectAttributes.addFlashAttribute("message", "Creation successful");
        return "redirect:/service/list";
    }

    @GetMapping(value = "/delete")
    public String deleteProduct(@RequestParam("serviceId") int serviceId,
                                RedirectAttributes redirectAttributes){
        this.iServiceService.deleteById(serviceId);
        redirectAttributes.addFlashAttribute("message", "Deleting successful");
        return "redirect:/service/list";
    }

    public String getString(){
        String result ="";
        for (int i=0; i<4; i++){
            result+=getRandomNumber();
        }
        System.out.println(result);
        return result;
    }

    public int getRandomNumber(){
        int number;
        number = (int)Math.round(Math.random()*9);
        System.out.println(number);
        return number;
    }
}
