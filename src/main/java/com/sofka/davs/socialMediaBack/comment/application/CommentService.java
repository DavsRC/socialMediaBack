package com.sofka.davs.socialMediaBack.comment.application;

import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.comment.domain.CommentRepository;
import com.sofka.davs.socialMediaBack.comment.infrastructure.mysql.MySqlCommentRepository;
import com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.dto.CommentDTO;
import com.sofka.davs.socialMediaBack.comment.infrastructure.rest_controller.mapper.CommentMapper;
import com.sofka.davs.socialMediaBack.post.infrastructure.mysql.MySqlPostRepository;
import com.sofka.davs.socialMediaBack.userlike.domain.UserLike;
import com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.dto.UserLikeDTO;
import com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.mapper.UserLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CommentService implements CommentRepository {

    @Autowired
    private MySqlCommentRepository mySqlCommentRepository;
    @Autowired
    private MySqlPostRepository mySqlPostRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    UserLikeMapper userLikeMapper;

    public CommentService() {
    }

    @Override
    public CommentDTO saveComment(CommentDTO commentDTO){
        Comment comment = commentMapper.convertDtoToComment(commentDTO);
        mySqlCommentRepository.save(comment);
        return commentDTO;
    }

    @Override
    public CommentDTO findCommentById(Integer commentId) {
        Optional<Comment> commentOptional = mySqlCommentRepository.findById(commentId);
        if(commentOptional.isEmpty()){
            throw new NoSuchElementException("It doesn't exist the comment with id: " + commentId);
        }
        return commentMapper.convertCommentToDTO(commentOptional.get());
    }

    @Override
    public Iterable<CommentDTO> findAllComments() {
        List<Comment> comments = mySqlCommentRepository.findAll();
        return comments.stream().map(comment -> commentMapper.convertCommentToDTO(comment)).toList();
    }

    @Override
    public CommentDTO updateComment(Integer commentId, CommentDTO commentDTO) {
        CommentDTO commentDtoFound =  findCommentById(commentId);
        commentDtoFound.setContent(commentDTO.getContent());
        commentDtoFound.setNumber_of_likes(commentDTO.getNumber_of_likes());
        Comment comment = commentMapper.convertDtoToComment(commentDtoFound);
        mySqlCommentRepository.save(comment);
        return commentDtoFound;
    }

    @Override
    public void deleteComment(Integer commentId) {
        CommentDTO commentDeleted =  findCommentById(commentId);
        Comment comment = commentMapper.convertDtoToComment(commentDeleted);
        mySqlCommentRepository.delete(comment);
    }

    @Override
    public CommentDTO assignUserLikeToComment(Integer commentId, UserLikeDTO userLikeDTO) {
        CommentDTO commentDTOFound = findCommentById(commentId);
        Comment comment = commentMapper.convertDtoToComment(commentDTOFound);
        UserLike userLike = userLikeMapper.convertDtoToUserLike(userLikeDTO);
        List<UserLike> userLikeList = new ArrayList<>();
        userLikeList.add(userLike);
        comment.setUserLikeList(userLikeList);
        mySqlCommentRepository.save(comment);
        return commentMapper.convertCommentToDTO(comment);
    }
}
