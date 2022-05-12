package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(String name,Integer id, Pageable pageable);
    void createProduct(Product product);
    void deleteProduct(int productId);
    Product detail(int productId);
    void updateProduct(Product product);
}
