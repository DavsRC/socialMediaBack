package com.sofka.davs.socialMediaBack.post.infrastructure.rest_controller.dto;

import com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.dto.CommentDTO;
import com.sofka.davs.socialMediaBack.userlike.domain.UserLike;
import com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.dto.UserLikeDTO;
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
public class PostDTO {

    private Integer id;

    private String title;

    private String content;

    private Integer number_of_likes;

    private List<CommentDTO> commentDTOList = new ArrayList<>();

    private List<UserLikeDTO> userLikeDTOS = new ArrayList<>();
}
