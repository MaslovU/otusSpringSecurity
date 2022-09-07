package com.maslov.securityhomework.repository;

import com.maslov.securityhomework.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
