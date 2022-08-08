package com.sofka.davs.socialMediaBack.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostDTO {

    private Integer id;
    private String title;
    private String content;
    private Integer numberOfLikes;
    private List<CommentDTO> comments = new ArrayList<>();
    private List<UserLikeDTO> userLikes = new ArrayList<>();
}
