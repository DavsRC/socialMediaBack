package com.sofka.davs.socialMediaBack.controller;


import com.sofka.davs.socialMediaBack.dto.PostDTO;
import com.sofka.davs.socialMediaBack.service.CommentServicempl;
import com.sofka.davs.socialMediaBack.service.PostServicempl;
import com.sofka.davs.socialMediaBack.service.UserLikeServicempl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post/")
@CrossOrigin("*")
public class PostController {

    @Autowired
    private PostServicempl postServicempl;

    @Autowired
    private CommentServicempl commentServicempl;

    @Autowired
    private UserLikeServicempl userLikeServicempl;

    @GetMapping("get/all/posts")
    public List<PostDTO> getAllPost(){
        return postServicempl.findAllPost();
    }

    @PostMapping("save/posts")
    public PostDTO createPost(@RequestBody PostDTO postDTO){
        return postServicempl.createPost(postDTO);
    }

    @PutMapping("update/{id}")
    public PostDTO editPost(@RequestBody PostDTO postDTO){
        return postServicempl.updatePost(postDTO);
    }

    @DeleteMapping("delete/{id}")
    public void deletePost(@PathVariable Integer id){
        postServicempl.deletePost(id);
    }
}
