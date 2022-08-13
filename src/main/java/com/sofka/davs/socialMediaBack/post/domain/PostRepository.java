package com.sofka.davs.socialMediaBack.post.domain;


import com.sofka.davs.socialMediaBack.userlike.UserLike;

public interface PostRepository {

    Post savePost(Post post);
    Post findPostById(Integer postId);
    Iterable<Post> findAllPosts();

}
