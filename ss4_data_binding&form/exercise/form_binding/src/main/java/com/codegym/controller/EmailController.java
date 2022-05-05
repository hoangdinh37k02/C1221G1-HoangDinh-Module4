package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @GetMapping(value = "/create")
    public String goCreateEmail(Model model){
        model.addAttribute("email",new Email());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createEmail(@ModelAttribute Email email, Model model){
        model.addAttribute("email", email);
        return "show";
    }
}
