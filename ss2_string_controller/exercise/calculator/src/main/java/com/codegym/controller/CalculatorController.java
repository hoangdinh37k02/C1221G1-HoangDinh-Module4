package com.codegym.controller;


import com.codegym.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICaculatorService iCaculatorService;

    @GetMapping("/")
    public String getHome(){
        return "index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam("num1") Double num1,
                             @RequestParam("num2") Double num2,
                             @RequestParam("result") String result,
                             Model model){
        model.addAttribute("finalResult", this.iCaculatorService.calculate(num1,num2,result));
        return "index";
    }
}
