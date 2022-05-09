package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAll();
    void createProduct(Product product);
    void deleteProduct(Product product);
    Product detail(int productId);
    void updateProduct(Product product);
    List<Product> searchByName(String name);
}
