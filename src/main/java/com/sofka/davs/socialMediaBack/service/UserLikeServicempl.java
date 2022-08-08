package com.sofka.davs.socialMediaBack.service;

import com.sofka.davs.socialMediaBack.dto.CustomMapper;
import com.sofka.davs.socialMediaBack.dto.UserLikeDto;
import com.sofka.davs.socialMediaBack.repository.UserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLikeServicempl implements UserLikeService {

    @Autowired
    private CustomMapper mapper;

    private UserLikeRepository userLikeRepository;

    @Override
    public UserLikeDto createUser(UserLikeDto UserLike) {
        return mapper
                .fromEntitytoUserLikeDto(userLikeRepository
                        .save(mapper.FromUserLikeDtoToEntity(new UserLikeDto())));
    }

    @Override
    public UserLikeDto findUser(UserLikeDto UserLike) {
        return null;
    }

    @Override
    public UserLikeDto createLike() {
        return null;
    }

    @Override
    public UserLikeDto deleteLike() {
        return null;
    }

    @Override
    public void deleteUserLike(Integer id) {

    }
}
