package com.sofka.davs.socialMediaBack.post.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.userlike.UserLike;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name= "Post")
@Table(name="post")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String content;

    private Integer number_of_likes;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", fetch = FetchType.LAZY)
    private List<Comment> commentList;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name="post_user_likes",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_like_id")
    )
    private List<UserLike> userLikeList = new ArrayList<>();
}
