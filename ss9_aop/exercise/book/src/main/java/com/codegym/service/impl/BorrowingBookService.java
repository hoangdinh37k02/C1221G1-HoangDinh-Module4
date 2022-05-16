package com.codegym.service.impl;

import com.codegym.model.BorrowingBook;
import com.codegym.repository.IBorrowingBook;
import com.codegym.service.IBorrowingBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingBookService implements IBorrowingBookService {
    @Autowired
    private IBorrowingBook iBorrowingBook;
    @Override
    public void save(BorrowingBook borrowingBook) {
        this.iBorrowingBook.save(borrowingBook);
    }

    @Override
    public List<BorrowingBook> findAll() {
        return this.iBorrowingBook.findAll();
    }

    @Override
    public BorrowingBook findById(int id) {
        return this.iBorrowingBook.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int borrowCode) {
        this.iBorrowingBook.deleteById(borrowCode);
    }
}
