package com.sofka.davs.socialMediaBack.dto;

import com.sofka.davs.socialMediaBack.entity.Post;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommentDTO {

    private Integer id;
    private String content;
    private String numberOfLikes;
    private Post postIdPost;
    private List<UserLikeDTO> userLikes = new ArrayList<>();
}
