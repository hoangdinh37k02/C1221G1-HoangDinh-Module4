package com.codegym.service.impl;

import com.codegym.model.Form;
import com.codegym.repository.IFormRepository;
import com.codegym.service.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService implements IFormService {
    @Autowired
    private IFormRepository iFormRepository;
    @Override
    public List<Form> findAll() {
        return this.iFormRepository.findAll();
    }

    @Override
    public void save(Form form) {
        this.iFormRepository.save(form);
    }
}
