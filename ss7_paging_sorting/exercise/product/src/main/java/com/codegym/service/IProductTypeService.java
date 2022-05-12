package com.codegym.service;

import com.codegym.model.ProductType;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> findAll();

    ProductType findById(Integer type);
}
