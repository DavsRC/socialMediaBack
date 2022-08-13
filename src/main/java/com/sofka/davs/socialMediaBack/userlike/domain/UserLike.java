package com.sofka.davs.socialMediaBack.userlike.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name= "UserLike")
@Table(name="user_like")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String dni;

    @ManyToMany
    @JsonBackReference
    @JoinTable(
            name="post_user_likes",
            joinColumns = @JoinColumn(name = "user_like_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    private List<Post> posts = new ArrayList<>();

    @ManyToMany
    @JsonBackReference
    @JoinTable(
            name="comment_user_likes",
            joinColumns = @JoinColumn(name = "user_like_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id")
    )
    private List<Comment> commentList  = new ArrayList<>();
}
