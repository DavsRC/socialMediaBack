package com.sofka.davs.socialMediaBack.service;

import com.sofka.davs.socialMediaBack.dto.CommentDTO;
import com.sofka.davs.socialMediaBack.entity.Comment;

import java.util.List;


public interface CommentService {

    CommentDTO createComment (CommentDTO commentDto);

    List<CommentDTO> findAllComments ();

    CommentDTO updateComment(CommentDTO commentDto);

    void deleteComment(Comment comment);

}
