package com.maslov.securityhomework.repository;

import com.maslov.securityhomework.domain.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<MyUser, Long> {
    MyUser findByName(String name);
}
