package com.sofka.davs.socialMediaBack.userlike.domain;


public interface UserLikeRepository {

    UserLike saveUserLike(UserLike userLike);
    UserLike findUserLikeById(Integer userLikeId);
    Iterable<UserLike> findAllUserLike();
    UserLike updateUserLike(Integer userLikeId, UserLike userLike);
    void deleteUserLike(Integer userLikeId);

}
