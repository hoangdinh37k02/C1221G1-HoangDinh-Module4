package com.codegym.service;

import com.codegym.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void create(Book book);

    Book findById(int bookId);

    void deleteById(int bookId);
}
