package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements IProductService {
    Product product = new Product();
    static Map<Integer, Product> productMap = new HashMap<>();
    static{
//        productMap = new HashMap<>();
        productMap.put(1,new Product(1,"Cosy",10,15000));
        productMap.put(2,new Product(2,"Oreo",10,20000));
        productMap.put(3,new Product(3,"Caro",40,8000));
        productMap.put(4,new Product(4,"Custom",50,30000));
    }
    @Override
    public List<Product> showAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void createProduct(Product product) {
        product.setProductId(this.showAll().size()+1);
//        (int) (Math.random()*1000)
        productMap.put(product.getProductId(), product);
    }

    @Override
    public void deleteProduct(int productId) {
        productMap.remove(productId);
    }

    @Override
    public Product detail(int productId) {
        return productMap.get(productId);
    }

    @Override
    public void updateProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList1 = new ArrayList<>();
        for (Product product: this.showAll()) {
            if ((product.getProductName().toLowerCase()).contains(name.toLowerCase())){
                productList1.add(product);
            }
        }
        return productList1;
    }
}
