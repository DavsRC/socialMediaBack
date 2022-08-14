package com.sofka.davs.socialMediaBack.post.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.userlike.domain.UserLike;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 5, max = 50,message="the title only can has a min length of 5 and a max length of 50")
    private String title;
    @Size(min = 10, max = 255,message="the content only can has a min length of 10 and a max length of 255")
    private String content;

    @Min(0)
    @Positive
    private Integer number_of_likes;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", fetch = FetchType.LAZY)
    private List<Comment> commentList = new ArrayList<>();

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name="post_user_likes",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_like_id")
    )
    private List<UserLike> userLikeList = new ArrayList<>();
}
