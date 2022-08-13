package com.sofka.davs.socialMediaBack.comment.infrastructure.mysql;

import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.comment.domain.CommentRepository;
import com.sofka.davs.socialMediaBack.post.domain.Post;
import com.sofka.davs.socialMediaBack.post.infrastructure.mysql.MySqlPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CommentService implements CommentRepository {

    @Autowired
    private MySqlCommentRepository mySqlCommentRepository;
    @Override
    public Comment saveComment(Comment comment){
        return mySqlCommentRepository.save(comment);
    }

    @Override
    public Comment findCommentById(Integer commentId) {
        Optional<Comment> commentOptional = mySqlCommentRepository.findById(commentId);
        if(commentOptional.isEmpty()){
            throw new NoSuchElementException("It doesn't exist the comment with id: " + commentId);
        }
        return commentOptional.get();
    }

    @Override
    public Iterable<Comment> findAllComments() {
        return mySqlCommentRepository.findAll();
    }

    @Override
    public Comment updateComment(Integer commentId, Comment comment) {
        Comment commentFound =  findCommentById(commentId);
        commentFound.setContent(comment.getContent());
        commentFound.setNumber_of_likes(comment.getNumber_of_likes());
        return mySqlCommentRepository.save(commentFound);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment commentDeleted =  findCommentById(commentId);
        mySqlCommentRepository.delete(commentDeleted);
    }

}
