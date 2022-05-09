package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    @Override
    public List<Product> showAll() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select s from Product s", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void createProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void deleteProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public Product detail(int productId) {
        return BaseRepository.entityManager.find(Product.class,productId);
    }

    @Override
    public void updateProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();

    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product: this.showAll()) {
            if ((product.getProductName().toLowerCase()).contains(name.toLowerCase())){
                productList.add(product);
            }
        }
        return productList;
    }
}
