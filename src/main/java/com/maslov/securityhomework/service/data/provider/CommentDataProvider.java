package com.maslov.securityhomework.service.data.provider;

import com.maslov.securityhomework.domain.Comment;
import com.maslov.securityhomework.repository.CommentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentDataProvider {
    private final CommentRepo commentRepo;

    public Comment create(Comment comment) {
        Comment commentFromDB = commentRepo.findByCommentForBook(comment.getCommentForBook());
        if (isNull(commentFromDB)) {
            return commentRepo.save(comment);
        }
        return commentFromDB;
    }
}
