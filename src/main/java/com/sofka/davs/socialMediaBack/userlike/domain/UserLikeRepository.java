package com.sofka.davs.socialMediaBack.userlike.domain;


import com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.dto.UserLikeDTO;

public interface UserLikeRepository {

    UserLikeDTO saveUserLike(UserLikeDTO userLikeDTO);
    UserLikeDTO findUserLikeById(Integer userLikeId);
    Iterable<UserLikeDTO> findAllUserLike();
    UserLikeDTO updateUserLike(Integer userLikeId, UserLikeDTO userLikeDTO);
    void deleteUserLike(Integer userLikeId);

}
