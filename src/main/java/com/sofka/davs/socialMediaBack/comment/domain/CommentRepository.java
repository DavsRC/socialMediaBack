package com.sofka.davs.socialMediaBack.comment.domain;

import com.sofka.davs.socialMediaBack.comment.domain.Comment;

public interface CommentRepository {

    Comment saveComment(Comment comment);
    Comment findCommentById(Integer commentId);
    Iterable<Comment> findAllComments();

}
