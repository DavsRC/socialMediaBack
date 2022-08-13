package com.sofka.davs.socialMediaBack.post.infrastructure.mysql;

import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.post.domain.Post;
import com.sofka.davs.socialMediaBack.post.domain.PostRepository;
import com.sofka.davs.socialMediaBack.userlike.UserLike;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

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
         Optional<Post> postOptional = mySqlPostRepository.findById(postId);
         if(postOptional.isEmpty()){
             throw new NoSuchElementException("It doesn't exist the post with id: " + postId);
         }
         return postOptional.get();
    }

    @Override
    public Iterable<Post> findAllPosts() {
        return mySqlPostRepository.findAll();
    }

    @Override
    public Post assignUserLike(Integer postId, UserLike userLike) {
        Post post = findPostById(postId);
        post.getUserLikeList().add(userLike);
        return mySqlPostRepository.save(post);
    }

    @Override
    public Post assignComment(Integer postId, Comment comment) {
        Post post = findPostById(postId);
        comment.setPost(post);
        post.getCommentList().add(comment);
        return mySqlPostRepository.save(post);
    }

}
