package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void deleteById(int blogId);

    Blog findById(int blogId);

    List<Blog> searchByName(String name);

}
