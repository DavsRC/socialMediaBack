package com.sofka.davs.socialMediaBack.controller;


import com.sofka.davs.socialMediaBack.dto.PostDto;
import com.sofka.davs.socialMediaBack.service.PostService;
import com.sofka.davs.socialMediaBack.service.UserLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post/")
@CrossOrigin("*")
public class GeneralController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserLikeService userLikeService;

    @GetMapping("get/all/posts")
    private List<PostDto> findAllPosts(){
        return postService.findAllPost();
    }

    @PostMapping("save/posts")
    public PostDto createPost(@RequestBody PostDto postDto){
        return postService.createPost(postDto);
    }

    @PutMapping("update/{id}")
    public PostDto updatePost(@RequestBody PostDto postDto){
        try{
            return postService.updatePost(postDto);
        }catch (IllegalStateException illegalStateException){
            return null;
        }
    }

    @DeleteMapping("update/{id}")
    public void deletePost(@RequestBody PostDto postDto){
        try{
            postService.deletePost(postDto.getId());
        }catch (RuntimeException runtimeException){
            System.out.println("The post doesn\'t exists");
        }
    }
}
