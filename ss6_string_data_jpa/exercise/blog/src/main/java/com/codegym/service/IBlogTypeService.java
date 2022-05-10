package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.BlogType;

import java.util.List;

public interface IBlogTypeService {
    List<BlogType> findAll();
}
