package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void createMusic(Music music) {
        iMusicRepository.createMusic(music);
    }

    @Override
    public void deleteSong(Music music) {
        iMusicRepository.deleteSong(music);
    }

    @Override
    public Music findById(int id) {
        return this.iMusicRepository.findById(id);
    }

    @Override
    public void updateSong(Music music) {
        iMusicRepository.updateSong(music);
    }
}
