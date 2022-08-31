package com.maslov.securityhomework.service.data.provider;

import com.maslov.securityhomework.domain.Comment;
import com.maslov.securityhomework.repository.CommentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentDataProvider {

    private final CommentRepo commentRepo;

    public Comment create(Comment comment) {
        return commentRepo.save(comment);
    }
}
