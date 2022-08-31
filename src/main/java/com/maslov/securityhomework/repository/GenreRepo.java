package com.maslov.securityhomework.repository;

import com.maslov.securityhomework.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre, Long> {
    Genre findByName(String name);
}
