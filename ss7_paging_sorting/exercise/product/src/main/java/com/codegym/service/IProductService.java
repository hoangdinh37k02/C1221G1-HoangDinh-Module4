package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAllByProductNameContaining(String name, Pageable pageable);
    Page<Product> findAllByProductNameContainingAndProduct_Type_Id(String name, String type, Pageable pageable);

    void createProduct(Product product);
    void deleteProduct(int productId);
    Product detail(int productId);
    void updateProduct(Product product);

}
