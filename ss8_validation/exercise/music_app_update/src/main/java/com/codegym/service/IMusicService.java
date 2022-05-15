package com.codegym.service;

import com.codegym.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMusicService {
    Page<Music> findAll(String name, Pageable pageable);

    void createMusic(Music music);

    void deleteSong(Music music);

    Music findById(int id);

    void updateSong(Music music);
}
