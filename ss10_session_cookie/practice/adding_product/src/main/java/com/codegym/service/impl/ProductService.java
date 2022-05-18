package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Page<Product> findAll(String name, Pageable pageable) {
        return this.iProductRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.iProductRepository.findById(id);
    }
}
