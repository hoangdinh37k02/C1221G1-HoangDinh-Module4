package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
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
    public List<Blog> searchByName(String name) {
        return this.iBlogRepository.searchByName("%"+name+"%");
    }


}
