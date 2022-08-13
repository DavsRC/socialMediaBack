package com.sofka.davs.socialMediaBack.post.infrastructure.mysql;

import com.sofka.davs.socialMediaBack.post.domain.Post;
import com.sofka.davs.socialMediaBack.post.domain.PostRepository;
import com.sofka.davs.socialMediaBack.post.infrastructure.mysql.MySqlPostRepository;
import com.sofka.davs.socialMediaBack.userlike.MySqlUserLikeRepository;
import com.sofka.davs.socialMediaBack.userlike.UserLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements PostRepository {


    @Autowired
    MySqlPostRepository mySqlPostRepository;


    @Override
    public Post savePost(Post post) {
        return mySqlPostRepository.save(post);
    }

    @Override
    public Post findPostById(Integer postId) {
        return mySqlPostRepository.findById(postId).get();
    }

    @Override
    public Iterable<Post> findAllPosts() {
        return mySqlPostRepository.findAll();
    }

}
