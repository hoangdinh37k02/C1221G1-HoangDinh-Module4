package com.codegym.service.customer.impl;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

//    @Override
//    public Page<Customer> findAll(String nameVal, Pageable pageable) {
//        return iCustomerRepository.findAllByCustomerNameContaining(nameVal,pageable);
//    }

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

    @Override
    public List<Customer> findAll() {
        return this.iCustomerRepository.findAll();
    }

    @Override
    public Page<Customer> find1(String nameVal, String emailVal, Pageable pageable) {
        return this.iCustomerRepository.findAllByCustomerNameContainingAndEmailContaining(nameVal, emailVal, pageable);
    }

    @Override
    public Page<Customer> find2(String nameVal, String emailVal, String typeVal, Pageable pageable) {
        return this.iCustomerRepository.findAllByCustomerNameContainingAndEmailContainingAndCustomerType_Id(nameVal,emailVal, Integer.parseInt(typeVal),pageable);
    }

    @Override
    public Page<Customer> findAllByStatus(int i, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Customer> find1(int i, String nameVal, String emailVal, Pageable pageable) {
        return this.iCustomerRepository.findAllByStatusAndCustomerNameContainingAndEmailContaining(0,nameVal,emailVal,pageable);
    }

    @Override
    public Page<Customer> find2(int i, String nameVal, String emailVal, String typeVal, Pageable pageable) {
        return this.iCustomerRepository.findAllByStatusAndCustomerNameContainingAndEmailContainingAndCustomerType_Id(0,nameVal,emailVal, Integer.parseInt(typeVal),pageable);
    }
}
