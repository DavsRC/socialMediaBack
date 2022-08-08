package com.sofka.davs.socialMediaBack.service;

import com.sofka.davs.socialMediaBack.dto.CommentDto;


public interface CommentService {

    CommentDto createComment(CommentDto commentDto);

    CommentDto updateComment(CommentDto commentDto);

    void deteleComment(Integer id);

}
