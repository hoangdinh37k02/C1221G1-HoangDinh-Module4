package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_type")
public class ProductType {
    @Id
    private Integer id;
    private String name;
    @OneToMany (mappedBy = "productType")
    private List<Product> productList;

    public ProductType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
