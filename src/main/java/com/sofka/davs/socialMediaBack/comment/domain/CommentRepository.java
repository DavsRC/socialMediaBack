package com.sofka.davs.socialMediaBack.comment.domain;

import com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.dto.CommentDTO;
import com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.dto.UserLikeDTO;

public interface CommentRepository {

    CommentDTO saveComment(CommentDTO commentDTO);
    CommentDTO findCommentById(Integer commentId);
    Iterable<CommentDTO> findAllComments();
    CommentDTO updateComment(Integer commentId, CommentDTO commentDTO);
    void deleteComment(Integer commentId);
    CommentDTO assignUserLikeToComment(Integer commentId, UserLikeDTO userLikeDTO);
}
