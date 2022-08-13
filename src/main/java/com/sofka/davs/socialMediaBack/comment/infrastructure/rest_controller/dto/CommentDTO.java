package com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDTO {

    private Integer id;
    private String content;
    private Integer number_of_likes;
}
