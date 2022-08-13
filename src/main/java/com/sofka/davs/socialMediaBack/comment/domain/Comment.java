package com.sofka.davs.socialMediaBack.comment.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sofka.davs.socialMediaBack.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity(name="Comment")
@Table(name="comment")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String content;

    private Integer number_of_likes;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @JsonBackReference
    private Post post;
}
