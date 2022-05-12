package com.codegym.service;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void createMusic(Music music);

    void deleteSong(Music music);

    Music findById(int id);

    void updateSong(Music music);
}
