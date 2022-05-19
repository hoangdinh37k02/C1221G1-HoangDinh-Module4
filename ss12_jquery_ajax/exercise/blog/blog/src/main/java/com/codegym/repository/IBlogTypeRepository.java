package com.codegym.repository;

import com.codegym.model.BlogType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogTypeRepository extends JpaRepository<BlogType, Integer> {
}
