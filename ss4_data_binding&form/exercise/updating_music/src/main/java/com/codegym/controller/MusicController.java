package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MusicController {
    @Autowired
    IMusicService iMusicService;

    @GetMapping(value = "/show")
    public String getList(Model model){
        model.addAttribute("musicList",this.iMusicService.showAll());
        return "show";
    }

    @GetMapping(value = "/update")
    public String goUpdateForm(Model model){

        model.addAttribute("music", new Music());
        return "update";
    }

    @PostMapping(value = "/update")
    public String updateMusic(@ModelAttribute Music music){
        this.iMusicService.save(music);
        return "redirect:/show";
    }
}
