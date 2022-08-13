package com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller;

import com.sofka.davs.socialMediaBack.comment.application.CommentService;
import com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/save")
    public ResponseEntity<CommentDTO> addComment(@RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<CommentDTO>(commentService.saveComment(commentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public Iterable<CommentDTO> getAllComments(){
        return commentService.findAllComments();
    }

    @GetMapping("/findById/{commentDtoId}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Integer commentDtoId) {
        return new ResponseEntity<CommentDTO>(commentService.findCommentById(commentDtoId), HttpStatus.OK);
    }

    @PutMapping("/update/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Integer commentId, @RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<CommentDTO>(commentService.updateComment(commentId, commentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
