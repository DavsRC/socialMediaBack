package com.sofka.davs.socialMediaBack.post.infrastructure.controller;

import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.post.domain.Post;
import com.sofka.davs.socialMediaBack.post.infrastructure.mysql.MySqlPostRepository;
import com.sofka.davs.socialMediaBack.post.infrastructure.mysql.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/save")
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        return new ResponseEntity<Post>(postService.savePost(post), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public Iterable<Post> getAllPosts(){
        return postService.findAllPosts();
    }

    @GetMapping("/findById/{postId}")
    public ResponseEntity<Post> getCommentById(@PathVariable Integer postId) {
        return new ResponseEntity<Post>(postService.findPostById(postId), HttpStatus.OK);
    }
}
