package com.sofka.davs.socialMediaBack.post.infrastructure.rest_controller;

import com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.dto.CommentDTO;
import com.sofka.davs.socialMediaBack.post.application.PostService;
import com.sofka.davs.socialMediaBack.post.infrastructure.rest_controller.dto.PostDTO;
import com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.dto.UserLikeDTO;
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
    public ResponseEntity<PostDTO> addPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<PostDTO>(postService.savePost(postDTO), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public Iterable<PostDTO> getAllPosts(){
        return postService.findAllPosts();
    }

    @GetMapping("/findById/{postId}")
    public ResponseEntity<PostDTO> getCommentById(@PathVariable Integer postId) {
        return new ResponseEntity<PostDTO>(postService.findPostById(postId), HttpStatus.OK);
    }

    @PutMapping("/assignUserLike/{postId}")
    public ResponseEntity<PostDTO> assignUserLikeToPost(@PathVariable Integer postId, @RequestBody UserLikeDTO userLike) {
        return new ResponseEntity<PostDTO>(postService.assignUserLike(postId, userLike), HttpStatus.CREATED);
    }

    @PutMapping("/assignComment/{postId}")
    public ResponseEntity<PostDTO> assignCommentToPost(@PathVariable Integer postId, @RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<PostDTO>(postService.assignComment(postId, commentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{postId}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Integer postId, @RequestBody PostDTO postDTO) {
        return new ResponseEntity<PostDTO>(postService.updatePost(postId, postDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer postId) {
        postService.deletePost(postId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
