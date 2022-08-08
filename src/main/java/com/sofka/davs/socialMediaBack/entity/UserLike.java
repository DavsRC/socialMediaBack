package com.sofka.davs.socialMediaBack.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user_like")
public class UserLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_like", nullable = false)
    private Integer id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "dni", nullable = false, length = 20)
    private String dni;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "comment_has_user_like",
            joinColumns = @JoinColumn(name = "user_like_id_user_like"),
            inverseJoinColumns = @JoinColumn(name = "comment_id_comments"))
    private Set<Comment> comments = new LinkedHashSet<>();

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "user_like_has_post",
            joinColumns = @JoinColumn(name = "user_like_id_user_like"),
            inverseJoinColumns = @JoinColumn(name = "post_id_post"))
    private Set<Post> posts = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

}