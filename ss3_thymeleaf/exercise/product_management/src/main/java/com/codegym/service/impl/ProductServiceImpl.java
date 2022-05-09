package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.repository.impl.BaseRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
            private IProductRepository iProductRepository;
    @Override
    public List<Product> showAll() {

        return this.iProductRepository.showAll();
    }

    @Override
    public void createProduct(Product product) {
        this.iProductRepository.createProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {

        this.iProductRepository.deleteProduct(product);
    }

    @Override
    public Product detail(int productId) {

        return iProductRepository.detail(productId);
    }

    @Override
    public void updateProduct(Product product) {

        this.iProductRepository.updateProduct(product);
    }

    @Override
    public List<Product> searchByName(String name) {
        return this.iProductRepository.searchByName(name);
    }
}
