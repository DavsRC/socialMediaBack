package com.sofka.davs.socialMediaBack.post.domain;


import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.dto.CommentDTO;
import com.sofka.davs.socialMediaBack.post.infrastructure.rest_controller.dto.PostDTO;
import com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.dto.UserLikeDTO;

public interface PostRepository {

    PostDTO savePost(PostDTO postDTO);
    PostDTO findPostById(Integer postId);
    Iterable<PostDTO> findAllPosts();
    PostDTO assignUserLike(Integer postId, UserLikeDTO userLike);
    PostDTO assignComment(Integer postId, CommentDTO commentDTO);
    PostDTO updatePost(Integer postId, PostDTO postDTO);
    void deletePost(Integer postId);

}
