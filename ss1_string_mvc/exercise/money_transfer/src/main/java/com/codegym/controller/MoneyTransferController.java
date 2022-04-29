package com.codegym.controller;

import com.codegym.service.IMoneyTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class MoneyTransferController {
    @Autowired
    private IMoneyTransfer iMoneyTransfer;

    @GetMapping(value = "/")
    public String homePage(){
        return "homepage";
    }

    @PostMapping(value="/transfer")
    public String transfer(
                           @RequestParam double usd,
                           Model model){
        model.addAttribute("result", this.iMoneyTransfer.transfer(usd));
        return "homepage";
    }
}
