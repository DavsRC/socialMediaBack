package com.sofka.davs.socialMediaBack.post.infrastructure.rest_controller.mapper;

import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.dto.CommentDTO;
import com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.mapper.CommentMapper;
import com.sofka.davs.socialMediaBack.post.domain.Post;
import com.sofka.davs.socialMediaBack.post.infrastructure.rest_controller.dto.PostDTO;
import com.sofka.davs.socialMediaBack.userlike.domain.UserLike;
import com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.dto.UserLikeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

     @Autowired
     private final CommentMapper commentMapper;

    public PostMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public PostDTO convertPostToDto(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setNumber_of_likes(post.getNumber_of_likes());
        postDTO.setNumber_of_likes(post.getNumber_of_likes());
        postDTO.setCommentDTOList(post.getCommentList()
                .stream()
                .map(commentMapper::convertCommentToDTO)
                .toList());
        postDTO.setUserLikeDTOS(post.getUserLikeList().stream().map(PostMapper::getUserLikeDTO).toList());
        return postDTO;
    }

    private static UserLikeDTO getUserLikeDTO(UserLike userLike) {
        UserLikeDTO userLikeDTO = new UserLikeDTO();
        userLikeDTO.setId(userLike.getId());
        userLikeDTO.setDni(userLike.getDni());
        userLikeDTO.setName(userLike.getName());
        return userLikeDTO;
    }

    public Post convertDtoToPost(PostDTO postDTO){
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setNumber_of_likes(postDTO.getNumber_of_likes());
        post.setCommentList(postDTO.getCommentDTOList()
                .stream()
                .map(commentDTO -> getComment(post, commentDTO))
                .toList());
        post.setUserLikeList(postDTO.getUserLikeDTOS()
                .stream()
                .map(PostMapper::getUserLike)
                .toList());
        return post;
    }

    private static UserLike getUserLike(UserLikeDTO userLikeDTO) {
        UserLike userLike = new UserLike();
        userLike.setId(userLikeDTO.getId());
        userLike.setDni(userLikeDTO.getDni());
        userLike.setName(userLikeDTO.getName());
        return userLike;
    }

    private static Comment getComment(Post post, CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setContent(commentDTO.getContent());
        comment.setNumber_of_likes(commentDTO.getNumber_of_likes());
        comment.setPost(post);
        return comment;
    }
}
