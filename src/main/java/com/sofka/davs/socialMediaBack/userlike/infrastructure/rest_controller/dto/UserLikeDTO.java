package com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.dto;

import com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.dto.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLikeDTO {

    private Integer id;
    private String name;
    private String dni;

}
