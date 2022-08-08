package com.sofka.davs.socialMediaBack.service;

import com.sofka.davs.socialMediaBack.dto.UserLikeDto;

public interface UserLikeService {
    UserLikeDto createUser (UserLikeDto UserLike);

    UserLikeDto findUser(UserLikeDto UserLike);

    UserLikeDto createLike();

    UserLikeDto deleteLike();

    void deleteUserLike(Integer id);
}
