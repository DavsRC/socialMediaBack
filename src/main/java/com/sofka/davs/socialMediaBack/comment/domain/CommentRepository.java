package com.sofka.davs.socialMediaBack.comment.domain;

import com.sofka.davs.socialMediaBack.post.domain.Post;

public interface CommentRepository {

    Comment saveComment(Comment comment);
    Comment findCommentById(Integer commentId);
    Iterable<Comment> findAllComments();
    Comment updateComment(Integer commentId, Comment comment);
    void deleteComment(Integer commentId);

}
