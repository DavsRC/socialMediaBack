package com.sofka.davs.socialMediaBack.service;

import com.sofka.davs.socialMediaBack.dto.UserLikeDTO;

public interface UserLikeService {
    UserLikeDTO createUser (UserLikeDTO UserLike);

    UserLikeDTO findUser(UserLikeDTO UserLike);

    UserLikeDTO createLike();

    UserLikeDTO deleteLike();

    void deleteUserLike(Integer id);
}
