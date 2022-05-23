package com.codegym.service.customer.impl;

import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(String nameVal, Pageable pageable) {
        return iCustomerRepository.findAllByCustomerNameContaining(nameVal,pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        iCustomerRepository.deleteById(customerId);
    }

    @Override
    public Customer findById(int customerId) {
        return iCustomerRepository.findById(customerId).orElse(null);
    }
}
