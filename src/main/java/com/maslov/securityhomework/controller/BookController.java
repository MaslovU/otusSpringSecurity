package com.maslov.securityhomework.controller;

import com.maslov.securityhomework.domain.Book;
import com.maslov.securityhomework.domain.Comment;
import com.maslov.securityhomework.model.BookModel;
import com.maslov.securityhomework.service.BookService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping()
public class BookController {
    private final BookService bookService;

    public BookController(BookService service) {
        this.bookService = service;
    }

    @GetMapping
    public String list(Model model) {
        Iterable<Book> books = bookService.getAllBook();

        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("books/onebook")
    public Book getBook(@RequestParam("id") long id) {
        return bookService.getBook(id);
    }

    @GetMapping("books/comment/id")
    public List<Comment> getComments(@RequestParam("id") long bookId) {
        return bookService.getComments(bookId);
    }

    // TODO add some request params and reate book
    @PostMapping("createBook")
    public String createBook(@RequestParam String name, Model model) {
//        bookService.createBook(book);

        List<Book> books = bookService.getAllBook();
        model.addAttribute("books", books);
        return "index";
    }

    @PutMapping("books/{id}")
    public Book updateBook(@PathVariable("id") Book bookFromDB,
                           @RequestBody BookModel bookModel) {
        return bookService.updateBook(bookModel, bookFromDB);
    }

    @DeleteMapping("books/{id}")
    public void delEmployee(@PathVariable Long id) {
        bookService.delBook(id);
    }
}
