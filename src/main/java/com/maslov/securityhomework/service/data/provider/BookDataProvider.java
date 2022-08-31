package com.maslov.securityhomework.service.data.provider;

import com.maslov.securityhomework.domain.Book;
import com.maslov.securityhomework.exception.MaslovBookException;
import com.maslov.securityhomework.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookDataProvider {

    private final BookRepo bookRepo;

    public Book getBook(long id) {
        try {
            return bookRepo.findById(id).orElseThrow(NullPointerException::new);
        } catch (NullPointerException e) {
            throw new MaslovBookException("Book with this id is not exist");
        }
    }

    public List<Book> getAllBook() {
        return bookRepo.findAll();
    }

    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }
}
