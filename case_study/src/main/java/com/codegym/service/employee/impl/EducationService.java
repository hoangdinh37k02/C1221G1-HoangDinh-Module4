package com.codegym.service.employee.impl;

import com.codegym.model.employee.Education;
import com.codegym.repository.employee.IEducationRepository;
import com.codegym.service.employee.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService implements IEducationService {
    @Autowired
    private IEducationRepository iEducationRepository;

    @Override
    public List<Education> findAll() {
        return this.iEducationRepository.findAll();
    }
}
