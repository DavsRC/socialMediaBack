package com.sofka.davs.socialMediaBack.comment.domain;

public interface CommentRepository {

    Comment saveComment(Comment comment);
    Comment findCommentById(Integer commentId);
    Iterable<Comment> findAllComments();

}
