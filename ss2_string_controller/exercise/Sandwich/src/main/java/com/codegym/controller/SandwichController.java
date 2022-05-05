package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/list")
    String getList(){
        return"list";
    }
    @PostMapping("/choose")
    public String show(
                       @RequestParam(value = "muoi", defaultValue = "") String[] muoi,
                       Model model) {
        model.addAttribute("muoi", muoi);
        return "show";
    }
}
