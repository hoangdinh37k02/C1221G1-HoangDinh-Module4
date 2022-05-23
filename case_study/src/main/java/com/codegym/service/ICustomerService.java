package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(String nameVal, Pageable pageable);

    void save(Customer customer);

    void deleteCustomer(int customerId);

    Customer findById(int customerId);
}
