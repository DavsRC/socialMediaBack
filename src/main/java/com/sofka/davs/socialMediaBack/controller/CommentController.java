package com.sofka.davs.socialMediaBack.controller;

import com.sofka.davs.socialMediaBack.dto.CommentDTO;
import com.sofka.davs.socialMediaBack.dto.PostDTO;
import com.sofka.davs.socialMediaBack.service.CommentServicempl;
import com.sofka.davs.socialMediaBack.service.PostServicempl;
import com.sofka.davs.socialMediaBack.service.UserLikeServicempl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comment/")
@CrossOrigin("*")
public class CommentController {

    @Autowired
    private PostServicempl postServicempl;

    @Autowired
    private CommentServicempl commentServicempl;

    @Autowired
    private UserLikeServicempl userLikeServicempl;

    @GetMapping("get/all/comments")
    public List<CommentDTO> getAll(){
        return commentServicempl.findAllComments();
    }

    @PostMapping("save/comments")
    public CommentDTO create(@RequestBody CommentDTO commentDTO){
        return commentServicempl.createComment(commentDTO);
    }

    @PutMapping("update/{id}")
    public CommentDTO edit(@RequestBody CommentDTO commentDTO){
        return commentServicempl.updateComment(commentDTO);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        commentServicempl.deleteComment(id);
    }
}
