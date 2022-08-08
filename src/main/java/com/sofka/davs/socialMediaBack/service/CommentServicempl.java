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
        return null;
    }

    @Override
    public CommentDTO updateComment(CommentDTO commentDto) {
        Optional targetComment = commentRepository.findById(commentDto.getId());
        if(targetComment.isPresent()){
            Comment commentEdited = commentRepository.save(customMapper.commentDtoToEntity(commentDto));
            var commentEditedDTO = customMapper.convertCommentToDto(commentEdited);
            return commentEditedDTO;
        }
        throw new IllegalStateException("The comment doesn't exist");
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.deleteById(comment.getId());
    }

}
