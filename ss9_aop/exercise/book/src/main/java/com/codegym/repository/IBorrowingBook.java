package com.codegym.repository;

import com.codegym.model.BorrowingBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowingBook extends JpaRepository<BorrowingBook, Integer> {
}
