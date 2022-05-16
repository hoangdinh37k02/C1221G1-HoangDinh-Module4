package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return this.iBookRepository.findAll();
    }

    @Override
    public void create(Book book) {
        this.iBookRepository.save(book);
    }

    @Override
    public Book findById(int bookId) {
        return this.iBookRepository.findById(bookId).orElse(null);
    }

    @Override
    public void deleteById(int bookId) {
        this.iBookRepository.deleteById(bookId);
    }
}
