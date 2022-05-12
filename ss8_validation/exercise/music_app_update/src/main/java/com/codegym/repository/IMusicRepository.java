package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMusicRepository extends JpaRepository<Music, Integer> {

}
