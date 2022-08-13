package com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.mapper;

import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.dto.CommentDTO;
import com.sofka.davs.socialMediaBack.post.domain.Post;
import com.sofka.davs.socialMediaBack.userlike.domain.UserLike;
import com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.dto.UserLikeDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommentMapper {

    public CommentDTO convertCommentToDTO(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setContent(comment.getContent());
        commentDTO.setNumber_of_likes(comment.getNumber_of_likes());
        commentDTO.setUserLikeDTOList(comment.getUserLikeList()
                .stream()
                .map(CommentMapper::getUserLikeDTO)
                .toList());
        return commentDTO;
    }

    private static UserLikeDTO getUserLikeDTO(UserLike userLike) {
        UserLikeDTO userLikeDTO = new UserLikeDTO();
        userLikeDTO.setId(userLike.getId());
        userLikeDTO.setDni(userLike.getDni());
        userLikeDTO.setName(userLike.getName());
        return userLikeDTO;
    }
    public Comment convertDtoToComment(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setContent(commentDTO.getContent());
        comment.setNumber_of_likes(commentDTO.getNumber_of_likes());
        comment.setUserLikeList(commentDTO.getUserLikeDTOList()
                .stream()
                .map(userLikeDTO -> getUserLike(userLikeDTO, comment))
                .toList());
        return comment;
    }

    private static UserLike getUserLike(UserLikeDTO userLikeDTO, Comment comment) {
        UserLike userLike = new UserLike();
        List<Comment> commentList = new ArrayList<>();
        userLike.setId(userLikeDTO.getId());
        userLike.setDni(userLikeDTO.getDni());
        userLike.setName(userLikeDTO.getName());
        commentList.add(comment);
        userLike.setCommentList(commentList);
        return userLike;
    }

}
