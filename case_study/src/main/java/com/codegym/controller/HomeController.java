package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.plaf.PanelUI;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/home"})
    public String goHome() {
        return "home";
    }
}
