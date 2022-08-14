package com.sofka.davs.socialMediaBack.userlike.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
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

    @Size(min = 10, max = 50,message="the name only can has a min length of 10 and a max length of 50")
    private String name;

    @Size(min = 8, max = 20,message="the name dni can has a min length of 8 and a max length of 20")
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
