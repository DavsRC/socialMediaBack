package com.sofka.davs.socialMediaBack.post.domain;


import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.userlike.UserLike;

public interface PostRepository {

    Post savePost(Post post);
    Post findPostById(Integer postId);
    Iterable<Post> findAllPosts();
    Post assignUserLike(Integer postId, UserLike userLike);
    Post assignComment(Integer postId, Comment comment);
    Post updatePost(Integer postId, Post post);

}
