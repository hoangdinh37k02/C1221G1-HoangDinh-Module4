package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(String name, Pageable pageable);
    void createProduct(Product product);
    void deleteProduct(int productId);
    Product detail(int productId);
    void updateProduct(Product product);
//    List<Product> searchByName(String name);
}
