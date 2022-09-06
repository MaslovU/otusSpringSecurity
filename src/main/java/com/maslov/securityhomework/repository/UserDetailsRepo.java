package com.maslov.securityhomework.repository;

import com.maslov.securityhomework.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, Long> {
    User findUserByName(String name);
}
