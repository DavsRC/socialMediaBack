package com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.mapper;

import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.dto.CommentDTO;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentDTO convertCommentToDTO(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setContent(comment.getContent());
        commentDTO.setNumber_of_likes(comment.getNumber_of_likes());
        return commentDTO;
    }

    public Comment convertDtoToComment(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setContent(commentDTO.getContent());
        comment.setNumber_of_likes(commentDTO.getNumber_of_likes());
        return comment;
    }

}
