package com.maslov.securityhomework.service;

import com.maslov.securityhomework.domain.Book;
import com.maslov.securityhomework.domain.Comment;
import com.maslov.securityhomework.model.BookModel;

import java.util.List;

public interface BookService {
    Book getBook(long id);

    List<Book> getAllBook();

    Book createBook(BookModel bookModel);

    Book updateBook(String id, BookModel book);

    void delBook(long id);

    List<Comment> getComments(long id);
}
