package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public Page<Music> findAll(String name, Pageable pageable) {
        return iMusicRepository.findAllBySongNameContaining(name, pageable);
    }

    @Override
    public void createMusic(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public void deleteSong(Music music) {
        iMusicRepository.delete(music);
    }

    @Override
    public Music findById(int id) {
        return this.iMusicRepository.findById(id).orElse(null);
    }

    @Override
    public void updateSong(Music music) {
        iMusicRepository.save(music);
    }
}
