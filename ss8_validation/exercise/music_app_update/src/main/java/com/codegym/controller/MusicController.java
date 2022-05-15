package com.codegym.controller;

import com.codegym.dto.MusicDto;
import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

//    Dislay list
    @GetMapping(value = {"/list","/"})
    public String showList(Model model, @PageableDefault(value = 3, sort = "songName", direction = Sort.Direction.DESC) Pageable pageable,
                           @RequestParam Optional<String> name){
        String nameVal = name.orElse("");
        model.addAttribute("musicList", iMusicService.findAll(nameVal, pageable));
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
                         BindingResult bindingResult){
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
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(this.iMusicService.findById(id),musicDto);
        model.addAttribute("musicDto",musicDto);
        return "update";
    }

    @PostMapping(value = "/update")
    public String updateSong(@ModelAttribute @Validated MusicDto musicDto,
                             BindingResult bindingResult){
        new MusicDto().validate(musicDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/update";
        } else {
            Music music=new Music();
            BeanUtils.copyProperties(musicDto,music);
            this.iMusicService.updateSong(music);
        }
        return "redirect:/list";
    }
}
