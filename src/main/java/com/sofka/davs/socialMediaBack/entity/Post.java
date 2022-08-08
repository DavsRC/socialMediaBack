package com.sofka.davs.socialMediaBack.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "post")
@RequiredArgsConstructor
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 45)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "number_of_likes")
    private Integer numberOfLikes;


    @JsonManagedReference
    @OneToMany(mappedBy = "postIdPost")
    private List<Comment> comments = new ArrayList<>();

    @JoinTable(name = "post_has_user_like",
            joinColumns = @JoinColumn(name = "post_id_post"),
            inverseJoinColumns = @JoinColumn(name = "user_like_iduser_like"))
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserLike> userLikes = new ArrayList<>();


}