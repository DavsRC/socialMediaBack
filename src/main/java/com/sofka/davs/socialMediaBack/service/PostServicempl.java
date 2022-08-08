package com.sofka.davs.socialMediaBack.service;

import com.sofka.davs.socialMediaBack.dto.CustomMapper;
import com.sofka.davs.socialMediaBack.dto.PostDTO;
import com.sofka.davs.socialMediaBack.entity.Post;
import com.sofka.davs.socialMediaBack.repository.CommentRepository;
import com.sofka.davs.socialMediaBack.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServicempl implements PostService{

    @Autowired
    private CustomMapper mapper;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserLikeService userLikeService;

    @Autowired
    private CommentService commentService;

    @Override
    public PostDTO createPost(PostDTO postDto) {
        Post post = mapper.dtoMapper(postDto);
        return mapper.convertPostToDto(postRepository.save(post));
    }

    @Override
    public List<PostDTO> findAllPost() {
        return postRepository.findAll()
                .stream()
                .map(mapper::convertPostToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO updatePost(PostDTO postDto) {
        Optional post = postRepository.findById(postDto.getId());
        if(post.isPresent()){
            var postEdited = postRepository.save(mapper.dtoMapper(postDto));
            var postEditedDTO = mapper.convertPostToDto(postEdited);
            return postEditedDTO;
        }
        throw new IllegalStateException("The post doesn't exists");
    }

    @Override
    public void deletePost(Integer id) {
        Post post = postRepository.findById(id).get();
//        if (post.getComments().size()>=0){
//            post.getComments().forEach(comment -> commentRepository.deleteById(comment.getId()));
//        }
        postRepository.deleteById(id);
    }
}
