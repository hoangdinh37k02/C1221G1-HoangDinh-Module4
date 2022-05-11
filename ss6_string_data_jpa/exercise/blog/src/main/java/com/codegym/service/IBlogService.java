package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void deleteById(int blogId);

    Blog findById(int blogId);

//    List<Blog> searchByName(String name);
    Page<Blog> getBlogByName(String name, Pageable pageable);

}
