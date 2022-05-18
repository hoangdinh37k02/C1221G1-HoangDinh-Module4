package com.codegym.service.impl;

import com.codegym.model.BlogType;
import com.codegym.repository.IBlogTypeRepository;
import com.codegym.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTypeService implements IBlogTypeService {
    @Autowired
    private IBlogTypeRepository iBlogTypeRepository;
    @Override
    public List<BlogType> findAll() {
        return this.iBlogTypeRepository.findAll();
    }

    @Override
    public BlogType findById(Integer id) {
        return this.iBlogTypeRepository.findById(id).orElse(null);
    }
}
