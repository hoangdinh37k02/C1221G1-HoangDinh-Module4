package com.codegym.service.impl;


import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class MusicServiceImpl implements IMusicService {
    static Map<String, Music> musicMap;

    static {
        musicMap = new HashMap<>();
        musicMap.put("dam cuoi nha", new Music("Dam cuoi nha", "Hồng Thanh", "pop",
                "https://zingmp3.vn/album/Dam-Cuoi-Nha-Single-Hong-Thanh-DJ-Mie/6BIFUZ9E.html"));
    }
    @Override
    public List<Music> showAll() {
        return new ArrayList<>(musicMap.values());
    }

    @Override
    public void save(Music music) {
        musicMap.put(music.getSongName(),music);
    }
}
