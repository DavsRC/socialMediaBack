package com.sofka.davs.socialMediaBack.post.application;

import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.dto.CommentDTO;
import com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.mapper.CommentMapper;
import com.sofka.davs.socialMediaBack.post.domain.Post;
import com.sofka.davs.socialMediaBack.post.domain.PostRepository;
import com.sofka.davs.socialMediaBack.post.infrastructure.mysql.MySqlPostRepository;
import com.sofka.davs.socialMediaBack.post.infrastructure.rest_controller.dto.PostDTO;
import com.sofka.davs.socialMediaBack.post.infrastructure.rest_controller.mapper.PostMapper;
import com.sofka.davs.socialMediaBack.userlike.domain.UserLike;
import com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.dto.UserLikeDTO;
import com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.mapper.UserLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService implements PostRepository {


    @Autowired
    MySqlPostRepository mySqlPostRepository;
    @Autowired
    PostMapper postMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserLikeMapper userLikeMapper;



    @Override
    public PostDTO savePost(PostDTO postDTO) {
        Post post = postMapper.convertDtoToPost(postDTO);
        mySqlPostRepository.save(post);
        return postDTO;
    }

    @Override
    public PostDTO findPostById(Integer postId) {
         Optional<Post> postOptional = mySqlPostRepository.findById(postId);
         if(postOptional.isEmpty()){
             throw new NoSuchElementException("It doesn't exist the post with id: " + postId);
         }
        return postMapper.convertPostToDto(postOptional.get());
    }

    @Override
    public Iterable<PostDTO> findAllPosts() {
        return mySqlPostRepository.findAll().stream()
                .map(post -> postMapper.convertPostToDto(post))
                .toList();
    }

    @Override
    public PostDTO assignUserLike(Integer postId, UserLikeDTO userLikeDTO) {
        PostDTO postDtoFound = findPostById(postId);
        Post post = postMapper.convertDtoToPost(postDtoFound);
        UserLike userLike = userLikeMapper.convertDtoToUserLike(userLikeDTO);
        List<UserLike> userLikeList = new ArrayList<>();
        userLikeList.add(userLike);
        post.setUserLikeList(userLikeList);
        mySqlPostRepository.save(post);
        return postMapper.convertPostToDto(post);
    }

    @Override
    public PostDTO assignComment(Integer postId, CommentDTO commentDTO) {
        PostDTO postDtoFound = findPostById(postId);
        Post post = postMapper.convertDtoToPost(postDtoFound);
        Comment comment = commentMapper.convertDtoToComment(commentDTO);
        comment.setPost(post);
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        post.setCommentList(comments);
        mySqlPostRepository.save(post);
        return postMapper.convertPostToDto(post);
    }
    @Override
    public PostDTO updatePost(Integer postId, PostDTO postDTO) {
        PostDTO postFound =  findPostById(postId);
        postFound.setTitle(postDTO.getTitle());
        postFound.setContent(postDTO.getContent());
        postFound.setNumber_of_likes(postDTO.getNumber_of_likes());
        Post post = postMapper.convertDtoToPost(postFound);
        mySqlPostRepository.save(post);
        return postFound;
    }

    @Override
    public void deletePost(Integer postId) {
        PostDTO postDeleted =  findPostById(postId);
        Post post = postMapper.convertDtoToPost(postDeleted);
        mySqlPostRepository.delete(post);
    }
}
