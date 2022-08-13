package com.sofka.davs.socialMediaBack.comment.infrastructure.mysql;

import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.comment.domain.CommentRepository;
import com.sofka.davs.socialMediaBack.post.infrastructure.mysql.MySqlPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements CommentRepository {

    @Autowired
    private MySqlCommentRepository mySqlCommentRepository;

    @Autowired
    private MySqlPostRepository mySqlPostRepository;

    @Override
    public Comment saveComment(Comment comment){
        return mySqlCommentRepository.save(comment);
    }

    @Override
    public Comment findCommentById(Integer commentId) {
        return mySqlCommentRepository.findById(commentId).get();
    }

    @Override
    public Iterable<Comment> findAllComments() {
        return mySqlCommentRepository.findAll();
    }

}
