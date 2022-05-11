package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public void deleteById(int blogId) {
        this.iBlogRepository.deleteById(blogId);
    }

    @Override
    public Blog findById(int blogId) {
        return this.iBlogRepository.findById(blogId).orElse(null);
    }

    @Override
    public Page<Blog> getBlogByName(String name, Pageable pageable) {
//        return this.iBlogRepository.findAllByBlogNameContaining(name,pageable);
        return this.iBlogRepository.findAllByName("%"+name+"%",pageable);
    }

//    @Override
//    public List<Blog> searchByName(String name) {
//        return this.iBlogRepository.searchByName("%"+name+"%");
//    }


}
