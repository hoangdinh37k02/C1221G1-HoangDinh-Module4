package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
            private IProductRepository iProductRepository;
    @Override
    public Page<Product> findAll(String name, Pageable pageable) {

        return this.iProductRepository.findAllByProductNameContaining(name, pageable);
    }

    @Override
    public void createProduct(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) {

        this.iProductRepository.deleteById(productId);
    }
//
    @Override
    public Product detail(int productId) {

        return iProductRepository.findById(productId).orElse(null);
    }

    @Override
    public void updateProduct(Product product) {

        this.iProductRepository.save(product);
    }

}
