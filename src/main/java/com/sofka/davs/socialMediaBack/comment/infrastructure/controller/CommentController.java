package com.sofka.davs.socialMediaBack.comment.infrastructure.controller;

import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.comment.infrastructure.mysql.CommentService;
import com.sofka.davs.socialMediaBack.comment.infrastructure.mysql.MySqlCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/save")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        return new ResponseEntity<Comment>(commentService.saveComment(comment), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public Iterable<Comment> getAllComments(){
        return commentService.findAllComments();
    }

    @GetMapping("/findById/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Integer commentId) {
        return new ResponseEntity<Comment>(commentService.findCommentById(commentId), HttpStatus.OK);
    }

}
