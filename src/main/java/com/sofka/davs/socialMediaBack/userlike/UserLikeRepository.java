package com.sofka.davs.socialMediaBack.userlike;


public interface UserLikeRepository {

    UserLike saveUserLike(UserLike userLike);
    UserLike findUserLikeById(Integer userLikeId);
    Iterable<UserLike> findAllUserLike();

}
