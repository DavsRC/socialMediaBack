package com.sofka.davs.socialMediaBack.dto;

import com.sofka.davs.socialMediaBack.entity.Comment;
import com.sofka.davs.socialMediaBack.entity.Post;
import com.sofka.davs.socialMediaBack.entity.UserLike;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomMapper {


    public PostDTO convertPostToDto(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setNumberOfLikes(post.getNumberOfLikes());
        postDTO.setUserLikes(post.getUserLikes().stream().map(this::convertUserLikeToDto).collect(Collectors.toList()));
        postDTO.setComments(post.getComments().stream().map(this::convertCommentToDto).collect(Collectors.toList()));
        return postDTO;
    }

    public  Post dtoMapper(PostDTO postDTO){
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setNumberOfLikes(postDTO.getNumberOfLikes());
        post.setUserLikes(postDTO.getUserLikes().stream().map(this::userLikeDtoMapper).collect(Collectors.toList()));
        post.setComments(postDTO.getComments().stream().map(this::commentDtoToEntity).collect(Collectors.toList()));
        return post;
    }

    public CommentDTO convertCommentToDto(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setContent(comment.getContent());
        commentDTO.setNumberOfLikes(comment.getNumberOfLikes());
        commentDTO.setUserLikes(comment.getUserLikes().stream().map(this::convertUserLikeToDto).collect(Collectors.toList()));
        return commentDTO;
    }
    public Comment commentDtoToEntity(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setContent(commentDTO.getContent());
        comment.setPostIdPost(commentDTO.getPostIdPost());
        comment.setNumberOfLikes(commentDTO.getNumberOfLikes());
        comment.setUserLikes(commentDTO.getUserLikes().stream().map(this::userLikeDtoMapper).collect(Collectors.toList()));
        return comment;
    }

    public UserLikeDTO convertUserLikeToDto(UserLike userLike){
        UserLikeDTO userLikeDTO = new UserLikeDTO();
        userLikeDTO.setId(userLike.getId());
        userLikeDTO.setUserName(userLike.getUserName());
        userLikeDTO.setDni(userLike.getDni());
        userLikeDTO.setComments(userLikeDTO.getComments());
        userLikeDTO.setPosts(userLikeDTO.getPosts());
        return userLikeDTO;
    }

    public UserLike userLikeDtoMapper(UserLikeDTO userLikeDTO){
        UserLike userLike = new UserLike();
        userLike.setId(userLikeDTO.getId());
        userLike.setUserName(userLikeDTO.getUserName());
        userLike.setDni(userLike.getDni());
        return userLike;
    }

}
