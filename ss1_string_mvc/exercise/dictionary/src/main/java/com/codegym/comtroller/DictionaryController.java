package com.codegym.comtroller;


import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping(value = "/")
    public String home(){
        return "home";
    }

    @PostMapping(value = "/translate")
    public String translate(@RequestParam String search,
                            Model model){
        model.addAttribute("result", iDictionaryService.translate(search));
        return "home";
    }
}
