package com.sofka.davs.socialMediaBack.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "comment")
@RequiredArgsConstructor
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comments", nullable = false)
    private Integer id;

    @Column(name = "content", nullable = false, length = 45)
    private String content;

    @Column(name = "number_of_likes", length = 45)
    private String numberOfLikes;


    @JsonBackReference

    @ManyToOne(fetch = FetchType.LAZY, optional = false)

    @JoinColumn(name = "post_id_post", nullable = false)
    private Post postIdPost;

    @ManyToMany
    @JoinTable(name = "comment_has_user_like",
            joinColumns = @JoinColumn(name = "comment_id_comments"),
            inverseJoinColumns = @JoinColumn(name = "user_like_iduser_like"))
    private List<UserLike> userLikes = new ArrayList<>();

}