package com.sofka.davs.socialMediaBack.dto;

import com.sofka.davs.socialMediaBack.entity.Comment;
import com.sofka.davs.socialMediaBack.entity.Post;
import lombok.Data;


import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class UserLikeDto {

    private Integer id;
    private String userName;
    private String dni;
    private Set<Comment> comments = new LinkedHashSet<>();
    private Set<Post> posts = new LinkedHashSet<>();
}
