package com.codegym.service.impl;

import com.codegym.model.BlogType;
import com.codegym.repository.IBlogTypeRepository;
import com.codegym.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTypeServiceImpl implements IBlogTypeService {
    @Autowired
    private IBlogTypeRepository iBlogTypeRepository;
    @Override
    public List<BlogType> findAll() {
        return this.iBlogTypeRepository.findAll();
    }
}
