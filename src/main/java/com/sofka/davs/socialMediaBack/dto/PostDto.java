package com.sofka.davs.socialMediaBack.dto;

import com.sofka.davs.socialMediaBack.entity.Comment;
import com.sofka.davs.socialMediaBack.entity.UserLike;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class PostDto {

    private Integer id;
    private String title;
    private String content;
    private Integer numberOfLikes;
    private Integer likes;
    private Set<UserLike> userLikes = new LinkedHashSet<>();
    private Set<Comment> comments = new LinkedHashSet<>();
}
