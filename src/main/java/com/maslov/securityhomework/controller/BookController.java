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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping()
public class BookController {
    private final BookService bookService;

    public BookController(BookService service) {
        this.bookService = service;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        return "index";
    }

    @GetMapping("main")
    public String list(Model model) {
        Iterable<Book> books = bookService.getAllBook();

        model.addAttribute("books", books);
        return "main";
    }

    @GetMapping("books/onebook")
    public Book getBook(@RequestParam("id") long id) {
        return bookService.getBook(id);
    }

    @GetMapping("books/comment/id")
    public List<Comment> getComments(@RequestParam("id") long bookId) {
        return bookService.getComments(bookId);
    }

    @PostMapping("createBook")
    public String createBook(Model model,
                             @RequestParam String name,
                             @RequestParam String authors,
                             @RequestParam String genre,
                             @RequestParam String year,
                             @RequestParam String listOfComments) {
        List<String> listOfAuthors = new ArrayList<>(Arrays.asList(authors.split(",")));
        List<String> comments = new ArrayList<>(Arrays.asList(listOfComments.split(",")));
        BookModel book = BookModel.builder()
                .name(name)
                .authors(listOfAuthors)
                .genre(genre)
                .year(year)
                .listOfComments(comments)
                .build();

        bookService.createBook(book);

        List<Book> books = bookService.getAllBook();
        model.addAttribute("books", books);
        return "main";
    }

    @GetMapping("edit")
    public String updateBook(Model model) {
        return "edit";
    }

    @PutMapping("books/{id}")
    public Book updateBook(@PathVariable("id") Book bookFromDB,
                           @RequestBody BookModel bookModel) {
        return bookService.updateBook(bookModel, bookFromDB);
    }

    @GetMapping("delete")
    public String delEmployee(@RequestParam Long id, Model model) {
        bookService.delBook(id);
        return "redirect:/main";
    }

    @GetMapping("delete-book")
    public String delEmployee() {
        return "delete";
    }
}
