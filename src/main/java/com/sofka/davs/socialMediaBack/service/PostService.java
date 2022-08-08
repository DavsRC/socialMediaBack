package com.sofka.davs.socialMediaBack.service;

import com.sofka.davs.socialMediaBack.dto.PostDTO;

import java.util.List;

public interface PostService {

    PostDTO createPost (PostDTO postDto);

    List<PostDTO> findAllPost ();
    PostDTO updatePost(PostDTO postDto);

    void deletePost(Integer id);
}
