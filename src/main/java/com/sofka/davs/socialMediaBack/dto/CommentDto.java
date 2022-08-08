package com.sofka.davs.socialMediaBack.dto;

import com.sofka.davs.socialMediaBack.entity.Post;
import com.sofka.davs.socialMediaBack.entity.UserLike;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class CommentDto {

    private Integer id;
    private String content;
    private String numberOfLikes;
    private Integer likes;
    private Post postIdPost;
    private Set<UserLike> userLikes = new LinkedHashSet<>();
}
