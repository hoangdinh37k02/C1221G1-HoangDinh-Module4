package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showAll();
    void createProduct(Product product);
    void deleteProduct(Product product);
    Product detail(int productId);
    void updateProduct(Product product);
    List<Product> searchByName(String name);
}
