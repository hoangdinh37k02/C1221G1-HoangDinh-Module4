package com.codegym.repository;

import com.codegym.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFormRepository extends JpaRepository <Form, Integer> {
}
