package com.sofka.davs.socialMediaBack.dto;

import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class UserLikeDTO {

    private Integer id;
    private String userName;
    private String dni;
    private List<CommentDTO> comments = new ArrayList<>();
    private List<PostDTO> posts = new ArrayList<>();

}
