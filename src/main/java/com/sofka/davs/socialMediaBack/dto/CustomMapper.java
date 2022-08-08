package com.sofka.davs.socialMediaBack.dto;

import com.sofka.davs.socialMediaBack.entity.Comment;
import com.sofka.davs.socialMediaBack.entity.Post;
import com.sofka.davs.socialMediaBack.entity.UserLike;
import org.springframework.stereotype.Component;

@Component
public class CustomMapper {

    public Comment fromCommentDtoToEntity(CommentDto dto){
        var comment = new Comment();
        comment.setId(dto.getId());
        comment.setContent(dto.getContent());
        comment.setNumberOfLikes(dto.getNumberOfLikes());
        comment.setUserLikes(dto.getUserLikes());
        comment.setPostIdPost(dto.getPostIdPost());
        return comment;
    }

    public CommentDto fromEntityToCommentDto(Comment entity){
        var commentDto = new CommentDto();
        commentDto.setId(entity.getId());
        commentDto.setContent(entity.getContent());
        commentDto.setNumberOfLikes(entity.getNumberOfLikes());
        commentDto.setUserLikes(entity.getUserLikes());
        commentDto.setPostIdPost(entity.getPostIdPost());
        return commentDto;
    }

    public Post fromPostDtoToEntity(PostDto dto){
        var post = new Post();
        post.setId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setNumberOfLikes(dto.getNumberOfLikes());
        post.setUserLikes(dto.getUserLikes());
        post.setComments(dto.getComments());
        return post;
    }

    public PostDto fromEntityToPostDto (Post entity){
        var postDto = new PostDto();
        postDto.setId(entity.getId());
        postDto.setTitle(entity.getTitle());
        postDto.setContent(entity.getContent());
        postDto.setNumberOfLikes(entity.getNumberOfLikes());
        postDto.setUserLikes(entity.getUserLikes());
        postDto.setComments(entity.getComments());
        return postDto;
    }

    public UserLike FromUserLikeDtoToEntity(UserLikeDto dto){
        var userLike = new UserLike();
        userLike.setId(dto.getId());
        userLike.setDni(dto.getDni());
        userLike.setUserName(dto.getUserName());
        userLike.setPosts(dto.getPosts());
        userLike.setComments(dto.getComments());
        return userLike;
    }

    public UserLikeDto fromEntitytoUserLikeDto (UserLike entity){
        var userLikeDto = new UserLikeDto();
        userLikeDto.setId(entity.getId());
        userLikeDto.setDni(entity.getDni());
        userLikeDto.setUserName(entity.getUserName());
        userLikeDto.setPosts(entity.getPosts());
        userLikeDto.setComments(entity.getComments());
        return userLikeDto;
    }
}
