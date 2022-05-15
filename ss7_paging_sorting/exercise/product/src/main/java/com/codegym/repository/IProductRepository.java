package com.codegym.repository;

import com.codegym.model.Product;
import com.codegym.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAllByProductNameContaining(String name, Pageable pageable);
    Page<Product> findAllByProductNameContainingAndProductType_Id(String name,int type, Pageable pageable);

}
