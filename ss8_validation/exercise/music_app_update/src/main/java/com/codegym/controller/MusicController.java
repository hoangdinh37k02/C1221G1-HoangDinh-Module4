package com.codegym.controller;

import com.codegym.dto.MusicDto;
import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

//    Dislay list
    @GetMapping(value = {"/list","/"})
    public String showList(Model model){
        model.addAttribute("musicList", iMusicService.findAll());
        return "list";
    }

//    create Song
    @GetMapping(value = "/create")
    public String goCreateForm(Model model){
        model.addAttribute("musicDto",new MusicDto());
        return "create";
    }

    @PostMapping(value = "create")
    public String create(@ModelAttribute @Validated MusicDto musicDto,
                         BindingResult bindingResult,
                         Model model){
        new MusicDto().validate(musicDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "create";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            this.iMusicService.createMusic(music);
        }
        return "redirect:/list";
    }

//    delete
    @GetMapping (value = "/delete")
    public String deleteSong(@RequestParam("id") int id){
        Music music = this.iMusicService.findById(id);
        this.iMusicService.deleteSong(music);
        return "redirect:/list";
    }

//    update Song
    @GetMapping (value = "/update")
    public String goUpdateForm(@RequestParam("id") int id, Model model){
        model.addAttribute("music",this.iMusicService.findById(id));
        return "update";
    }

    @PostMapping(value = "/update")
    public String updateSong(@ModelAttribute Music music){
        this.iMusicService.updateSong(music);
        return "redirect:/list";
    }
}
