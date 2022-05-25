package com.codegym.service.service;

import com.codegym.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    Page<Service> findAll(String nameVal, Pageable pageable);

    void save(Service service);

    List<Service> findAll();

    void deleteById(int serviceId);
}
