package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {
    @Override
    public List<Music> findAll() {
        TypedQuery<Music> typedQuery = BaseRepository.entityManager.createQuery("select s from Music s",Music.class);
        return typedQuery.getResultList();
    }

    @Override
    public void createMusic(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public void deleteSong(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();
        BaseRepository.entityManager.remove(music);
        entityTransaction.commit();
    }

    @Override
    public Music findById(int id) {

        return BaseRepository.entityManager.find(Music.class,id);
    }

    @Override
    public void updateSong(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }
}
