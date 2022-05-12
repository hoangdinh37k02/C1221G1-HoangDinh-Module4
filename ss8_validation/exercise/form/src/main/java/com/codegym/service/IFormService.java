package com.codegym.service;

import com.codegym.model.Form;

import java.util.List;

public interface IFormService {
    List<Form> findAll();

    void save(Form form);
}
