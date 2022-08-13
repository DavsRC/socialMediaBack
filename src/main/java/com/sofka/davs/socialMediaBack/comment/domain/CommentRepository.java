package com.sofka.davs.socialMediaBack.comment.domain;

import com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.dto.CommentDTO;

public interface CommentRepository {

    CommentDTO saveComment(CommentDTO commentDTO);
    CommentDTO findCommentById(Integer commentId);
    Iterable<CommentDTO> findAllComments();
    CommentDTO updateComment(Integer commentId, CommentDTO commentDTO);
    void deleteComment(Integer commentId);
}
