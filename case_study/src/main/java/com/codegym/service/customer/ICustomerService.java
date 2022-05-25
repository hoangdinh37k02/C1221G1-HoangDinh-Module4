package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
//    Page<Customer> findAll(String nameVal, Pageable pageable);

    void save(Customer customer);

    void deleteCustomer(int customerId);

    Customer findById(int customerId);

    List<Customer> findAll();

    Page<Customer> find1(String nameVal, String emailVal, Pageable pageable);

    Page<Customer> find2(String nameVal, String emailVal, String typeVal, Pageable pageable);
}
