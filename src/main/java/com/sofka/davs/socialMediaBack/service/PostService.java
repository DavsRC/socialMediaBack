package com.sofka.davs.socialMediaBack.service;

import com.sofka.davs.socialMediaBack.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost (PostDto postDto);

    List<PostDto> findAllPost ();

    PostDto getById(Integer id);

    PostDto updatePost(PostDto postDto);

    void deletePost(Integer id);
}
