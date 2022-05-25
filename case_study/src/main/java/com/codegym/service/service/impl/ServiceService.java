package com.codegym.service.service.impl;

import com.codegym.repository.service.IServiceRepository;
import com.codegym.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {
    @Autowired
    private IServiceRepository iServiceRepository;

    @Override
    public Page<com.codegym.model.service.Service> findAll(String nameVal, Pageable pageable) {
        return this.iServiceRepository.findAllByServiceNameContaining(nameVal,pageable);
    }

    @Override
    public void save(com.codegym.model.service.Service service) {
        this.iServiceRepository.save(service);
    }

    @Override
    public List<com.codegym.model.service.Service> findAll() {
        return this.iServiceRepository.findAll();
    }

    @Override
    public void deleteById(int serviceId) {
        this.iServiceRepository.deleteById(serviceId);
    }

}
