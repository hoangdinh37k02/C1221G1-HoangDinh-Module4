package com.codegym.controller;

import com.codegym.model.Form;
import com.codegym.service.IFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FormController {
    @Autowired
    private IFormService iFormService;

    @GetMapping(value = {"/list","/"})
    public String showList(Model model){
        model.addAttribute("formList", this.iFormService.findAll());
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model){
        model.addAttribute("formDto", new FormDto());
        return "/create";
    }
    @PostMapping(value = "/create")
    public String create(@ModelAttribute @Validated FormDto formDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            return "create";
        } else {
            Form form = new Form();
            BeanUtils.copyProperties(formDto,form);
            this.iFormService.save(form);
            redirectAttributes.addFlashAttribute("message","Create Form"+form.toString()+"success");
        }
        return "redirect:/list";
    }
}
