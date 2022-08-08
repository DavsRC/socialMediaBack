package com.sofka.davs.socialMediaBack.service;

import com.sofka.davs.socialMediaBack.dto.CommentDto;
import com.sofka.davs.socialMediaBack.dto.CustomMapper;
import com.sofka.davs.socialMediaBack.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServicempl implements CommentService{

    @Autowired
    private CustomMapper mapper;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        return mapper
                .fromEntityToCommentDto(commentRepository
                        .save(mapper.fromCommentDtoToEntity(commentDto)));
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto) {

        var commentOptional= commentRepository.findById(commentDto.getId());
        if(commentOptional.isPresent()){
            var commentUpdated= commentRepository.save(mapper.fromCommentDtoToEntity(commentDto));
            var commentUpdatedDto =mapper.fromEntityToCommentDto(commentUpdated);
            return commentUpdatedDto;
        }

        throw new IllegalStateException("ERROR the commentary don´t exist");
    }

    @Override
    public void deteleComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
