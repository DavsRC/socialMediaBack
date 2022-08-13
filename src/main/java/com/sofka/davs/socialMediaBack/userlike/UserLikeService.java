package com.sofka.davs.socialMediaBack.userlike;

import com.sofka.davs.socialMediaBack.post.infrastructure.mysql.MySqlPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserLikeService implements UserLikeRepository{

    @Autowired
    MySqlUserLikeRepository mySqlUserLikeRepository;

    @Autowired
    MySqlPostRepository mySqlPostRepository;

    @Override
    public UserLike saveUserLike(UserLike userLike) {
        return mySqlUserLikeRepository.save(userLike);
    }

    @Override
    public UserLike findUserLikeById(Integer userLikeId) {
        return mySqlUserLikeRepository.findById(userLikeId).get();
    }

    @Override
    public Iterable<UserLike> findAllUserLike() {
        return mySqlUserLikeRepository.findAll();
    }
    public UserLike getUserLikeById(Integer id) {
        Optional<UserLike> userLikeOptional = mySqlUserLikeRepository.findById(id);
        if (userLikeOptional.isEmpty()) {
            throw new NoSuchElementException("It doesn't exist the UserLike with id: " + id);
        }
        return userLikeOptional.get();
    }
}
