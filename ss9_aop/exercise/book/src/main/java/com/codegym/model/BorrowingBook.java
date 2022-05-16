package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name="borrow_book")
public class BorrowingBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "bookId")
    private Book bookId;

    public BorrowingBook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }
}
