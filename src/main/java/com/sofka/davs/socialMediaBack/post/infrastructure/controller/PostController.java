package com.sofka.davs.socialMediaBack.post.infrastructure.controller;

import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.post.domain.Post;
import com.sofka.davs.socialMediaBack.post.infrastructure.mysql.PostService;
import com.sofka.davs.socialMediaBack.userlike.UserLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/assignPost/{postId}")
    public ResponseEntity<Post> assignUserLikeToPost(@PathVariable Integer postId, @RequestBody UserLike userLike) {
        return new ResponseEntity<Post>(postService.assignUserLike(postId, userLike), HttpStatus.CREATED);
    }

    @PutMapping("/assignComment/{postId}")
    public ResponseEntity<Post> assignCommentToPost(@PathVariable Integer postId, @RequestBody Comment comment) {
        return new ResponseEntity<Post>(postService.assignComment(postId, comment), HttpStatus.CREATED);
    }

    @PutMapping("/updatePost/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer postId, @RequestBody Post post) {
        return new ResponseEntity<Post>(postService.updatePost(postId, post), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer postId) {
        postService.deletePost(postId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
