package com.maslov.securityhomework.service.data.provider;

import com.maslov.securityhomework.domain.Author;
import com.maslov.securityhomework.repository.AuthorRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorDataProvider {
    private final AuthorRepo authorRepo;

    public List<Author> findByName(String name) {
        return authorRepo.findByName(name);
    }

    public Author create(Author author) {
        return authorRepo.save(author);
    }
}
