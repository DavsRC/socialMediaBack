package com.sofka.davs.socialMediaBack.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "postID", nullable = false)
    private Integer id;

    @Column(name = "tittle", nullable = false, length = 45)
    private String tittle;

    @Column(name = "content", nullable = false, length = 45)
    private String content;

    @Column(name = "number_of_likes", nullable = false)
    private Integer numberOfLikes;

    @Column(name = "likes", nullable = false)
    private Integer likes;

    @ManyToMany
    @JoinTable(name = "user_like_has_post",
            joinColumns = @JoinColumn(name = "post_postID"),
            inverseJoinColumns = @JoinColumn(name = "user_like_user_likeID"))
    private Set<UserLike> userLikes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "postPostid")
    private Set<Comment> comments = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(Integer numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Set<UserLike> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(Set<UserLike> userLikes) {
        this.userLikes = userLikes;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

}