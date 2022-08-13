package com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.mapper;

import com.sofka.davs.socialMediaBack.userlike.domain.UserLike;
import com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.dto.UserLikeDTO;
import org.springframework.stereotype.Component;

@Component
public class UserLikeMapper {

    public UserLikeDTO convertUserLikeToDTo(UserLike userLike){
        UserLikeDTO userLikeDTO = new UserLikeDTO();
        userLikeDTO.setId(userLike.getId());
        userLikeDTO.setDni(userLike.getDni());
        userLikeDTO.setName(userLike.getName());
        return userLikeDTO;
    }

    public UserLike convertDtoToUserLike(UserLikeDTO userLikeDTO){
        UserLike userLike = new UserLike();
        userLike.setId(userLikeDTO.getId());
        userLike.setDni(userLikeDTO.getDni());
        userLike.setName(userLikeDTO.getName());
        return userLike;
    }

}
