package com.codegym.model;

public class Music {
    private String songName;
    private String singer;
    private String type;
    private String link;

    public Music (){}

    public Music(String songName, String singer, String type, String link) {
        this.songName = songName;
        this.singer = singer;
        this.type = type;
        this.link = link;
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
}
