package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private IBlogTypeService iBlogTypeService;
//show list
    @GetMapping(value = {"/list","/"})
    public String showList(Model model, @PageableDefault(value = 2) Pageable pageable,
                           @RequestParam Optional<String> name){
        String nameVal = name.orElse("");
        model.addAttribute("blogList",this.iBlogService.getBlogByName(nameVal, pageable));
        model.addAttribute("blogTypeList",this.iBlogTypeService.findAll());
        model.addAttribute("nameVal",nameVal);
        return "list";
    }
//    creat new blog
    @GetMapping (value = "/create")
    public String goCreateForm(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("blogTypeList",this.iBlogTypeService.findAll());
        return "/create";
    }
    @PostMapping (value = "/create")
    public String create(@ModelAttribute Blog blog){
        this.iBlogService.save(blog);
        return "redirect:/list";
    }

//delete
    @GetMapping(value = "/delete")
    public String delete(@RequestParam int blogId){
        this.iBlogService.deleteById(blogId);
        return "redirect:/list";
    }

//    update
    @GetMapping(value = "/update")
    public String goUpdateForm(@RequestParam int blogId,Model model){
        model.addAttribute("blog",this.iBlogService.findById(blogId));
        model.addAttribute("blogTypeList",this.iBlogTypeService.findAll());
        return "/update";
    }
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Blog blog){
        this.iBlogService.save(blog);
        return "redirect:/list";
    }
//search
//    @PostMapping(value = "/search")
//    public String search(@RequestParam String name, Model model){
//        model.addAttribute("blogList", this.iBlogService.searchByName(name));
//        return "/list";
//    }
}