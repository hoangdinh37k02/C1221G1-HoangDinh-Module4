package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {
    private int id;
    @NotEmpty
    @NotBlank
    @Size(min = 1,max = 800, message = "number of character is between 1 to 800 character")
    private String songName;
    @NotEmpty
    @NotBlank
    @Size(min = 1,max = 300, message = "number of character is between 1 to 300 character")
    private String singer;
    @NotEmpty
    @NotBlank
    @Size(min = 1,max = 1000, message = "number of character is between 1 to 1000 character")
    private String type;
    private String link;

    public MusicDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;
        if (musicDto.getSongName().contains("@")||musicDto.getSongName().contains(";")
                ||musicDto.getSongName().contains(".")||musicDto.getSongName().contains("=")
                ||musicDto.getSongName().contains("-")||musicDto.getSongName().contains("+")
                ||musicDto.getSongName().contains(",")||musicDto.getSongName().contains("*")){
            errors.rejectValue("songName", "songName.default", "default error");
        }
        if (musicDto.getSinger().contains("@")||musicDto.getSinger().contains(";")
                ||musicDto.getSinger().contains(".")||musicDto.getSinger().contains("=")
                ||musicDto.getSinger().contains("-")||musicDto.getSinger().contains("+")
                ||musicDto.getSinger().contains(",")||musicDto.getSinger().contains("*")){
            errors.rejectValue("singer", "songName.default", "default error");
        }
        if (musicDto.getType().contains("@")||musicDto.getType().contains(";")
                ||musicDto.getType().contains(".")||musicDto.getType().contains("=")
                ||musicDto.getType().contains("-")||musicDto.getType().contains("+")
                ||musicDto.getType().contains("*")){
            errors.rejectValue("type", "songName.default", "default error");
        }
    }
}
