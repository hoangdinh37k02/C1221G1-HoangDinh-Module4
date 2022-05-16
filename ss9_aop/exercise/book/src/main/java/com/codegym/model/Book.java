package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String bookName;
//    @Min(value = 0)
    private int quantity;
    @OneToMany (mappedBy = "bookId")
    private List<BorrowingBook> borrowingBookList;

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<BorrowingBook> getBorrowingBookList() {
        return borrowingBookList;
    }

    public void setBorrowingBookList(List<BorrowingBook> borrowingBookList) {
        this.borrowingBookList = borrowingBookList;
    }
}
