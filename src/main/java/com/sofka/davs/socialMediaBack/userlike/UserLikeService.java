package com.sofka.davs.socialMediaBack.userlike;

import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.post.infrastructure.mysql.MySqlPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserLikeService implements UserLikeRepository{

    @Autowired
    MySqlUserLikeRepository mySqlUserLikeRepository;

    @Override
    public UserLike saveUserLike(UserLike userLike) {
        return mySqlUserLikeRepository.save(userLike);
    }

    @Override
    public UserLike findUserLikeById(Integer userLikeId) {
        Optional<UserLike> userLikeOptional = mySqlUserLikeRepository.findById(userLikeId);
        if(userLikeOptional.isEmpty()){
            throw new NoSuchElementException("It doesn't exist the user like with id: " + userLikeId);
        }
        return userLikeOptional.get();
    }

    @Override
    public Iterable<UserLike> findAllUserLike() {
        return mySqlUserLikeRepository.findAll();
    }

    @Override
    public UserLike updateUserLike(Integer userLikeId, UserLike userLike) {
        UserLike userLikeFound =  findUserLikeById(userLikeId);
        userLikeFound.setDni(userLike.getDni());
        userLikeFound.setName(userLike.getName());
        return mySqlUserLikeRepository.save(userLikeFound);
    }

    @Override
    public void deleteUserLike(Integer userLikeId) {
        UserLike userLikeDeleted =  findUserLikeById(userLikeId);
        mySqlUserLikeRepository.delete(userLikeDeleted);
    }

    public UserLike getUserLikeById(Integer id) {
        Optional<UserLike> userLikeOptional = mySqlUserLikeRepository.findById(id);
        if (userLikeOptional.isEmpty()) {
            throw new NoSuchElementException("It doesn't exist the UserLike with id: " + id);
        }
        return userLikeOptional.get();
    }
}
