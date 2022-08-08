package com.sofka.davs.socialMediaBack.service;

import com.sofka.davs.socialMediaBack.dto.CommentDTO;
import com.sofka.davs.socialMediaBack.dto.CustomMapper;
import com.sofka.davs.socialMediaBack.entity.Comment;
import com.sofka.davs.socialMediaBack.repository.CommentRepository;
import com.sofka.davs.socialMediaBack.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServicempl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CustomMapper customMapper;

    @Autowired
    private UserLikeService userLikeService;

    @Override
    public CommentDTO createComment(CommentDTO commentDTO) {
        return customMapper
                .convertCommentToDto(commentRepository.save(customMapper.commentDtoToEntity(commentDTO)));

    }

    @Override
    public List<CommentDTO> findAllComments() {
        return commentRepository.findAll()
                .stream()
                .map(comment -> customMapper.convertCommentToDto(comment))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO updateComment(CommentDTO commentDto) {
        List<Comment> commentList = commentRepository.findAll();
        Comment comment = commentRepository.findById(commentDto.getId()).get();
        if(comment != null){
            Comment comment1 = commentRepository.save(customMapper.commentDtoToEntity(commentDto));
            CommentDTO commentDTO = customMapper.convertCommentToDto(comment1);
            return commentDTO;
        }
        throw new IllegalStateException("The post doesn't exists");
    }

    @Override
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }

}
