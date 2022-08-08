package com.sofka.davs.socialMediaBack.service;

import com.sofka.davs.socialMediaBack.dto.CustomMapper;
import com.sofka.davs.socialMediaBack.dto.UserLikeDTO;
import com.sofka.davs.socialMediaBack.repository.UserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLikeServicempl implements UserLikeService {

    @Autowired
    private CustomMapper mapper;

    private UserLikeRepository userLikeRepository;

    @Override
    public UserLikeDTO createUser(UserLikeDTO UserLike) {
        return null;
    }

    @Override
    public UserLikeDTO findUser(UserLikeDTO UserLike) {
        return null;
    }

    @Override
    public UserLikeDTO createLike() {
        return null;
    }

    @Override
    public UserLikeDTO deleteLike() {
        return null;
    }

    @Override
    public void deleteUserLike(Integer id) {

    }
}
