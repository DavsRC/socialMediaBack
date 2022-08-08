package com.sofka.davs.socialMediaBack.service;

import com.sofka.davs.socialMediaBack.dto.CustomMapper;
import com.sofka.davs.socialMediaBack.dto.PostDto;
import com.sofka.davs.socialMediaBack.entity.Post;
import com.sofka.davs.socialMediaBack.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static jdk.dynalink.linker.support.Guards.isNull;

@Service
public class PostServicempl implements PostService{

    @Autowired
    private CustomMapper mapper;

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        return mapper
                .fromEntityToPostDto(postRepository
                        .save(mapper.fromPostDtoToEntity(postDto)));
    }

    @Override
    public List<PostDto> findAllPost() {
        var posts = postRepository.findAll();
        var postDtos = posts.stream().map(post -> mapper.fromEntityToPostDto(post)).toList();
        return postDtos;
    }

    @Override
        public PostDto getById(Integer id) {
        Post post = postRepository.findById(id).get();
        if(post.getId() == null){
            new RuntimeException();
        }
        PostDto postDto = mapper.fromEntityToPostDto(post);
        return postDto;
    }

    @Override
    public PostDto updatePost(PostDto postDto) {
        var oldPost = postRepository.findById(postDto.getId());
        if (oldPost.isPresent()) {
            var updatedPost = mapper.updateExistingPost(oldPost.get(), postDto);
            var savedPost = postRepository.save(oldPost.get());
            return mapper.fromEntityToPostDto(savedPost);
        }
        throw new IllegalStateException("ERROR the post doesn't exist");
    }

    @Override
    public void deletePost(Integer id) {
            PostDto postDto = getById(id);
            postRepository.deleteById(postDto.getId());
    }
}
