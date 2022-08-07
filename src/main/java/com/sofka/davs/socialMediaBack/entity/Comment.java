package com.sofka.davs.socialMediaBack.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "commentID", nullable = false)
    private Integer id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "number_of_likes", nullable = false, length = 45)
    private String numberOfLikes;

    @Column(name = "likes", nullable = false)
    private Integer likes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_postID", nullable = false)
    private Post postPostid;

    @ManyToMany
    @JoinTable(name = "user_like_has_comment",
            joinColumns = @JoinColumn(name = "comment_commentID"),
            inverseJoinColumns = @JoinColumn(name = "user_like_user_likeID"))
    private Set<UserLike> userLikes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(String numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Post getPostPostid() {
        return postPostid;
    }

    public void setPostPostid(Post postPostid) {
        this.postPostid = postPostid;
    }

    public Set<UserLike> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(Set<UserLike> userLikes) {
        this.userLikes = userLikes;
    }

}