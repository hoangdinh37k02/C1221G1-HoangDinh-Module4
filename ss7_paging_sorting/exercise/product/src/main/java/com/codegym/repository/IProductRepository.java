package com.codegym.repository;

import com.codegym.model.Product;
import com.codegym.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAllByProductNameContaining(String name, Pageable pageable);
    Page<Product> findAllByProductNameContainingAndProductTypeAndProductId(String name,Integer idType, Pageable pageable);
//    List<Product> findAll();
//    void createProduct(Product product);
//    void deleteProduct(Product product);
//    Product detail(int productId);
//    void updateProduct(Product product);
//    List<Product> searchByName(String name);
}
