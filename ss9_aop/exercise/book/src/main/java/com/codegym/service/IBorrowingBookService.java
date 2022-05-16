package com.codegym.service;

import com.codegym.model.BorrowingBook;

import java.util.List;

public interface IBorrowingBookService {
    void save(BorrowingBook borrowingBook);
    List<BorrowingBook> findAll();

    BorrowingBook findById(int id);

    void deleteById(int borrowCode);
}
