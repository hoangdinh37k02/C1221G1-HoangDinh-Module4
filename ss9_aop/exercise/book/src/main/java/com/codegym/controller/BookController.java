package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.BorrowingBook;
import com.codegym.service.IBookService;
import com.codegym.service.IBorrowingBookService;
import com.codegym.service.MyException;
import com.codegym.service.impl.BorrowingBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private IBorrowingBookService iBorrowingBookService;

//    Book list
    @GetMapping (value = {"/list","/"})
    public String home(Model model){

        model.addAttribute("bookList",this.iBookService.findAll());
        return "list";
    }


//    create Book
    @GetMapping(value = "/create")
    public String goCreateBookForm(Model model){
        model.addAttribute("book",new Book());
        return "create";
    }
    @PostMapping(value = "/create")
    public String creatNewBook(@ModelAttribute Book book){
        iBookService.create(book);
        return "redirect:/list";
    }

//    Delete
    @GetMapping(value = "/delete")
    public String deleteBook(@RequestParam int bookId,
                             RedirectAttributes redirectAttributes){
        this.iBookService.deleteById(bookId);
        redirectAttributes.addFlashAttribute("message","Deleting successful");
        return "redirect:/list";
    }

//    Update
    @GetMapping(value = "/update")
    public String goUpdateForm(Model model,
                               @RequestParam int bookId){
        model.addAttribute("book", this.iBookService.findById(bookId));
        return "update";
    }
    @PostMapping(value = "/update")
    public String updateBook(@ModelAttribute Book book,
                             RedirectAttributes redirectAttributes){
        this.iBookService.create(book);
        redirectAttributes.addFlashAttribute("message","Updating successful");
        return "redirect:/list";
    }

//    detail borrowing book
    @GetMapping(value = "/detail")
    public String detail(@RequestParam int bookId,
                         Model model){
        model.addAttribute("book",this.iBookService.findById(bookId));
        return "detail";
    }
    @PostMapping(value = "/detail")
    public String bookBorrow(@ModelAttribute Book book,
                         Model model,
                         RedirectAttributes redirectAttributes){
//        update new quantity for book after borrowing
            if (book.getQuantity()==0){
                redirectAttributes.addFlashAttribute("message","Out of book");
                return "redirect:/list";
            }else {
                int quantity = book.getQuantity() - 1;
                book.setQuantity(quantity);
                iBookService.create(book);
//        create new borrowing
                BorrowingBook borrowingBook = new BorrowingBook();
                borrowingBook.setBookId(book);
                this.iBorrowingBookService.save(borrowingBook);
//        show created borrowing
                model.addAttribute("borrow", this.iBorrowingBookService.findById(this.iBorrowingBookService.findAll().size()));
                model.addAttribute("message", "Borrowing Successful");
                return "borrow";
            }

    }

//    return Book
    @PostMapping(value = "/return")
    public String returnBook(@RequestParam int code,
                             Model model){
        model.addAttribute("borrowingBook", this.iBorrowingBookService.findById(code));

        return "return";
    }

    @PostMapping(value = "/confirm")
    public String bookConfirm(@RequestParam int borrowCode, int bookId,
                          RedirectAttributes redirectAttributes){
        this.iBorrowingBookService.deleteById(borrowCode);
        Book book = this.iBookService.findById(bookId);
        int quantity = book.getQuantity()+1;
        book.setQuantity(quantity);
        this.iBookService.create(book);
        redirectAttributes.addFlashAttribute("message", "Returning Successful");
        return "redirect:/list";
    }

    @ExceptionHandler(MyException.class)
    public String showErrorPage(){
        return "error";
    }
}
