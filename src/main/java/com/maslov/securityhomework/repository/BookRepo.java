package com.maslov.securityhomework.repository;

import com.maslov.securityhomework.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> getBooksByName(String name);
}
