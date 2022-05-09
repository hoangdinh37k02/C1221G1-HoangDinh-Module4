package com.codegym.repository;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();
    void createMusic(Music music);
    void deleteSong(Music music);
    Music findById(int id);
    void updateSong(Music music);
}
