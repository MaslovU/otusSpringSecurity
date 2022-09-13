package com.maslov.securityhomework.repository;

import com.maslov.securityhomework.domain.YearOfPublish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearRepo extends JpaRepository<YearOfPublish, Long> {
    YearOfPublish findByDateOfPublish(String year);
}
